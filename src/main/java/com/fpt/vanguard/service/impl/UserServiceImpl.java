package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.UserDtoRequest;
import com.fpt.vanguard.dto.response.UserDtoResponse;
import com.fpt.vanguard.entity.User;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.UserMapstruct;
import com.fpt.vanguard.mapper.mybatis.UserMapper;
import com.fpt.vanguard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserMapstruct userMapstruct;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDtoResponse> getAllUser() {
        var listEntity = userMapper.findAll();
        if (listEntity.isEmpty()) throw new AppException(ErrorCode.LIST_USER_EMPTY);
        return userMapstruct.toUserDtoResponseList(listEntity);
    }

    @Override
    public UserDtoResponse getUserByUserName(String userName) {
        var entity = userMapper.findByUsername(userName)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXIST));
        return userMapstruct.toUserDtoResponse(entity);
    }

    @Override
    public UserDtoResponse getUserInfo() {
        var securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        User entity = userMapper.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXIST));
        return userMapstruct.toUserDtoResponse(entity);
    }

    @Override
    public Integer createUser(UserDtoRequest request) {
        String username = request.getUsername();
        if (userMapper.isExist(username)) throw new AppException(ErrorCode.USER_EXISTED);
        var passwordEncoded = passwordEncoder.encode(request.getPassword());
        request.setPassword(passwordEncoded);
        var entity = userMapstruct.toUser(request);
        return userMapper.insert(entity);
    }

    @Override
    public Integer deleteUser(String username) {
        if (!userMapper.isExist(username)) throw new AppException(ErrorCode.USER_NOT_EXIST);

        return userMapper.delete(username);
    }
}
