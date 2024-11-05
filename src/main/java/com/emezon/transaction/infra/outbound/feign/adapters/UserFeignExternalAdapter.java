package com.emezon.transaction.infra.outbound.feign.adapters;

import com.emezon.transaction.domain.models.external.User;
import com.emezon.transaction.domain.spi.external.IUserExternalOutPort;
import com.emezon.transaction.infra.outbound.feign.IUserFeignClient;
import com.emezon.transaction.infra.outbound.feign.dtos.UserFeign;
import com.emezon.transaction.infra.outbound.feign.mappers.UserFeignMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFeignExternalAdapter implements IUserExternalOutPort {

    private final IUserFeignClient userFeignClient;

    @Override
    public User findByEmail(String email) {
        UserFeign userFeign = userFeignClient.findUserByEmail(email);
        if (userFeign == null) {
            return null;
        }
        return UserFeignMapper.toUser(userFeign);
    }
}
