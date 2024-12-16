package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.BangLuongDtoRequest;
import com.fpt.vanguard.dto.response.BangLuongDtoResponse;
import com.fpt.vanguard.service.BangLuongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/salary")
@RequiredArgsConstructor
@CrossOrigin
public class BangLuongController {
    private final BangLuongService bangLuongService;

    @GetMapping
    public ApiResponse<List<BangLuongDtoResponse>> getAllBangLuong() {
        return ApiResponse.<List<BangLuongDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(bangLuongService.getAllBangLuong())
                .build();
    }

    @GetMapping("employee/{id}")
    public ApiResponse<List<BangLuongDtoResponse>> getBangLuong(@PathVariable("id") String maNhanVien) {
        return ApiResponse.<List<BangLuongDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(bangLuongService.getBangLuongNhanVien(maNhanVien))
                .build();
    }

    @GetMapping("employee-by-month/{id}")
    public ApiResponse<BangLuongDtoResponse> getBangLuongTheoThang(@PathVariable("id") String maNhanVien) {
        return ApiResponse.<BangLuongDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(bangLuongService.getBangLuongNhanVienByMonth(maNhanVien))
                .build();
    }

    @PostMapping("/employee")
    public ApiResponse<Integer> getBangLuong(@RequestBody BangLuongDtoRequest request) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(bangLuongService.saveBangLuong(request))
                .build();
    }

    @GetMapping("/test")
    public ApiResponse<Integer> getBangLuongTinhLuong() {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(bangLuongService.updateBangLuongTinhLuong())
                .build();
    }
}
