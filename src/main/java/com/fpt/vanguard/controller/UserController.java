package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.UserDtoResponse;
import com.fpt.vanguard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('MANAGER')")
    public ApiResponse<List<UserDtoResponse>> getAll() {
        return ApiResponse.<List<UserDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(userService.getAllUser())
                .build();
    }
}
