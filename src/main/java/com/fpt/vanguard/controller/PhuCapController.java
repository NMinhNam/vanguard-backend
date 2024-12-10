package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.PhuCapDtoResponse;
import com.fpt.vanguard.service.PhuCapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/phu-cap")
@RequiredArgsConstructor
@CrossOrigin
public class PhuCapController {
    private final PhuCapService phuCapService;

    @GetMapping
    public ApiResponse<List<PhuCapDtoResponse>> getAllPhuCaps() {
        return ApiResponse.<List<PhuCapDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(phuCapService.getAllPhuCaps())
                .build();
    }
}
