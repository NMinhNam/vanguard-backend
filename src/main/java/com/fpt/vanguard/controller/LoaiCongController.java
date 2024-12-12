package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.LoaiCongDtoRequest;
import com.fpt.vanguard.dto.response.LoaiCongDtoResponse;
import com.fpt.vanguard.service.LoaiCongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attendance-types")
@RequiredArgsConstructor
@CrossOrigin
public class LoaiCongController {
    private final LoaiCongService loaiCongService;

    @GetMapping
    public ApiResponse<List<LoaiCongDtoResponse>> getAllLoaiCongs() {
        return ApiResponse.<List<LoaiCongDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(loaiCongService.getAllLoaiCong())
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> saveLoaiCong(@RequestBody LoaiCongDtoRequest loaiCongDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(loaiCongService.saveLoaiCong(loaiCongDtoRequest))
                .build();
    }

    @DeleteMapping("/{tenLoaiCong}")
    public ApiResponse<Integer> deleteLoaiCong(@PathVariable("tenLoaiCong") String tenLoaiCong) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(loaiCongService.deleteLoaiCong(tenLoaiCong))
                .build();
    }

}
