package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.UserDtoResponse;
import com.fpt.vanguard.entity.User;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.UserMapstruct;
import com.fpt.vanguard.mapper.mybatis.UserMapper;
import com.fpt.vanguard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserMapstruct userMapstruct;

    @Override
    public List<UserDtoResponse> getAllUser() {
        var listEntity = userMapper.findAll();
        if (listEntity.isEmpty()) throw new AppException(ErrorCode.LIST_USER_EMPTY);
        return userMapstruct.toUserDtoResponseList(listEntity);
    }
}
