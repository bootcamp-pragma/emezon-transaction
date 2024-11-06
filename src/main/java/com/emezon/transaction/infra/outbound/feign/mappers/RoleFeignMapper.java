package com.emezon.transaction.infra.outbound.feign.mappers;

import com.emezon.transaction.domain.models.external.Role;
import com.emezon.transaction.infra.outbound.feign.dtos.RoleFeign;

public class RoleFeignMapper {

    private RoleFeignMapper() { }

    public static RoleFeign toRoleFeign(Role role) {
        return new RoleFeign(role.getId(), role.getName(), role.getDescription());
    }

    public static Role toRole(RoleFeign roleFeign) {
        return new Role(roleFeign.getId(), roleFeign.getName(), roleFeign.getDescription());
    }

}
