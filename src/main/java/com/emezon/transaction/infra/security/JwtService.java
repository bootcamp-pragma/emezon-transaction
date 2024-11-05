package com.emezon.transaction.infra.security;

import com.emezon.transaction.domain.spi.IJwtService;
import com.emezon.transaction.infra.outbound.feign.dtos.UserFeign;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtService implements IJwtService {
    @Value("${spring.security.jwt.secret}")
    private String secret;

    @Value("${spring.security.jwt.expiration-time}")
    private long expirationTime;

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, claims -> (String) claims.get("sub"));
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public <T> T extractClaim(String token, Function<Map<String, Object>, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        Map<String, Object> claimsMap = new HashMap<>(claims);
        return claimsResolver.apply(claimsMap);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, claim -> {
            Number exp = (Number) claim.get("exp");
            long expLong = exp.longValue();
            return new Date(expLong * 1000);
        });
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    @Override
    public boolean isTokenValid(String token, Map<String, Object> data) {
        final String username = extractUsername(token);
        if (isTokenExpired(token)) {
            throw new ExpiredJwtException(null, null, "Token has expired");
        }
        return username.equals(data.get("username"));
    }

    @Override
    public String getRoleName(String token) {
        return extractClaim(token, claims -> (String) claims.get(SecurityConstants.ROLE_NAME_CLAIM));
    }

    @Override
    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (expirationTime * 1000L)))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

//    public String getAuthenticatedUserId() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof UserFeign user) {
//                return user.getId();
//            }
//        }
//        return null;
//    }


}
