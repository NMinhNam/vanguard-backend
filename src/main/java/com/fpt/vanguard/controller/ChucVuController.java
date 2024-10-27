package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.ChucVuDtoResponse;
import com.fpt.vanguard.service.ChucVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/chuc-vu")
@RequiredArgsConstructor
@CrossOrigin
public class ChucVuController {
    private final ChucVuService chucVuService;

    @GetMapping
    public ApiResponse<List<ChucVuDtoResponse>> getAllChucVu() {
        return ApiResponse.<List<ChucVuDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(chucVuService.getAllChucVu())
                .build();
    }
}
