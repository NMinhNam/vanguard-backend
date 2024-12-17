package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.ViPhamDtoRequest;
import com.fpt.vanguard.dto.response.ViPhamDtoResponse;
import com.fpt.vanguard.service.ViPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/violations")
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

    @PostMapping
    public ApiResponse<Integer> saveViPham(@RequestBody ViPhamDtoRequest viPhamDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(viPhamService.saveViPham(viPhamDtoRequest))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteViPham(@PathVariable("id") String maViPham) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(viPhamService.deleteViPham(maViPham))
                .build();
    }
}
