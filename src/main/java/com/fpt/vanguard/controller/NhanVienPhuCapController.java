package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.PhuCapDtoRequest;
import com.fpt.vanguard.dto.response.PhuCapDtoResponse;
import com.fpt.vanguard.service.NhanVienPhuCapService;
import com.fpt.vanguard.service.PhuCapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee-allowance")
@RequiredArgsConstructor
@CrossOrigin
public class NhanVienPhuCapController {
    private final PhuCapService phuCapService;
    private final NhanVienPhuCapService nhanVienPhuCapService;

    @PostMapping("/getNhanVienPhuCap")
    public ApiResponse<PhuCapDtoResponse> getNhanVienPhuCap(@RequestBody PhuCapDtoRequest phuCapDtoRequest) {
        return ApiResponse.<PhuCapDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(phuCapService.getNhanVienPhuCap(phuCapDtoRequest))
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> saveNhanVienPhuCap(@RequestBody PhuCapDtoRequest phuCapDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(phuCapService.savePhuCap(phuCapDtoRequest))
                .build();
    }

    @DeleteMapping
    public ApiResponse<Integer> deleteNhanVienPhuCap(@RequestBody PhuCapDtoRequest phuCapDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(nhanVienPhuCapService.deteleNhanVienPhuCap(phuCapDtoRequest))
                .build();
    }
}