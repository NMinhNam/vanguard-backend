package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.UserDtoResponse;

import java.util.List;

public interface UserService {
    List<UserDtoResponse> getAllUser();
}
