package com.emezon.transaction.infra.outbound.feign.dtos;

import com.emezon.transaction.infra.security.SecurityConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleFeign implements GrantedAuthority {

    private String id;
    private String name;
    private String description;

    @Override
    public String getAuthority() {
        return SecurityConstants.ROLE_PREFIX + this.name;
    }
}
