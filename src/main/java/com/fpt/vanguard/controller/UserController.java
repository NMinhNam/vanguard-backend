package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.UserDtoRequest;
import com.fpt.vanguard.dto.response.UserDtoResponse;
import com.fpt.vanguard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ApiResponse<List<UserDtoResponse>> getListUserInfo() {
        return ApiResponse.<List<UserDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(userService.getAllInfoUser())
                .build();
    }

    @GetMapping("/search")
    public ApiResponse<UserDtoResponse> getUser(@RequestParam("username") String username) {
        return ApiResponse.<UserDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(userService.getUserByUserName(username))
                .build();
    }

    @GetMapping("/me")
    public ApiResponse<UserDtoResponse> getUserInfo() {
        return ApiResponse.<UserDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(userService.getUserInfo())
                .build();
    }

    @PostMapping("/register")
    public ApiResponse<Integer> createUser(@RequestBody UserDtoRequest request) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(userService.createUser(request))
                .build();
    }

    @DeleteMapping("/{username}")
    public ApiResponse<Integer> deleteUser(@PathVariable("username") String username) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(userService.deleteUser(username))
                .build();
    }

    @PutMapping("/updateRole")
    public ApiResponse<Integer> updateRole(@RequestBody UserDtoRequest request) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(userService.updateRoleUser(request))
                .build();
    }

    @PutMapping("/updateStatus")
    public ApiResponse<Integer> updateStatus(@RequestBody UserDtoRequest request) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(userService.updateStatusUser(request))
                .build();
    }

}
