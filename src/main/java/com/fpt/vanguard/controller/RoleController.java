package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.RoleDtoResponse;
import com.fpt.vanguard.dto.response.UserDtoResponse;
import com.fpt.vanguard.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
@RequiredArgsConstructor
@CrossOrigin
public class RoleController {
    private final RoleService roleService;
    @GetMapping()
    public ApiResponse<List<RoleDtoResponse>> getListUserInfo() {
        return ApiResponse.<List<RoleDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(roleService.findAllRoles())
                .build();
    }
}
