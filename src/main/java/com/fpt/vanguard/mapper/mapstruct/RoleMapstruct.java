package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapstruct {
    RoleMapstruct INSTANCE = Mappers.getMapper(RoleMapstruct.class);

    @Mapping(target = "roleId", source = "roleId")
    Role toRole(Integer roleId);
}
