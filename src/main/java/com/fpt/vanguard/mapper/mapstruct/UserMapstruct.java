package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.response.RoleDtoResponse;
import com.fpt.vanguard.dto.response.UserDtoResponse;
import com.fpt.vanguard.entity.Role;
import com.fpt.vanguard.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapstruct {
    List<UserDtoResponse> toUserDtoResponseList(List<User> userList);
    RoleDtoResponse toRoleDtoResponse(Role role);
}
