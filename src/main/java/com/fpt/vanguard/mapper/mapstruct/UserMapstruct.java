package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.UserDtoRequest;
import com.fpt.vanguard.dto.response.RoleDtoResponse;
import com.fpt.vanguard.dto.response.UserDtoResponse;
import com.fpt.vanguard.entity.Role;
import com.fpt.vanguard.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = RoleMapstruct.class)
public interface UserMapstruct {
    UserDtoResponse toUserDtoResponse(User user);
    List<UserDtoResponse> toUserDtoResponseList(List<User> userList);
    RoleDtoResponse toRoleDtoResponse(Role role);

    UserMapstruct INSTANCE = Mappers.getMapper(UserMapstruct.class);

    @Mapping(target = "userName", source = "userDtoRequest.username")
    @Mapping(target = "password", source = "userDtoRequest.password")
    @Mapping(target = "role", source = "userDtoRequest.roleId")
    User toUser(UserDtoRequest userDtoRequest);
}
