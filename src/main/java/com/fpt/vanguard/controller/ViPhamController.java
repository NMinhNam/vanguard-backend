package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.ViPhamDtoResponse;
import com.fpt.vanguard.service.ViPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/vi-pham")
@RequiredArgsConstructor
@CrossOrigin
public class ViPhamController {
    private final ViPhamService viPhamService;

    @GetMapping
    public ApiResponse<List<ViPhamDtoResponse>> getAllViPham() {
        return ApiResponse.<List<ViPhamDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(viPhamService.getAllViPhams())
                .build();
    }
}
