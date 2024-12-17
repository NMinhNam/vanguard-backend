package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.UserDtoRequest;
import com.fpt.vanguard.dto.response.UserDtoResponse;

import java.util.List;

public interface UserService {
    List<UserDtoResponse> getAllUser();
    UserDtoResponse getUserByUserName(String userName);
    UserDtoResponse getUserInfo();
    Integer createUser(UserDtoRequest request);
    Integer deleteUser(String username);
    Integer updateRoleUser(UserDtoRequest request);
    List<UserDtoResponse> getAllInfoUser();
    UserDtoResponse getInfoUserByUserName(String userName);
    Integer updateStatusUser(UserDtoRequest request);
}
