package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.NgayLeDtoRequest;
import com.fpt.vanguard.dto.response.NgayLeDtoResponse;
import com.fpt.vanguard.service.NgayLeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/holidays")
@RequiredArgsConstructor
@CrossOrigin
public class NgayLeController {
    private final NgayLeService ngayLeService;

    @GetMapping
    public ApiResponse<List<NgayLeDtoResponse>> getAllNgayLes() {
        return ApiResponse.<List<NgayLeDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(ngayLeService.getAllNgayLe())
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> saveNgayLe(@RequestBody NgayLeDtoRequest ngayLeDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(ngayLeService.saveNgayLe(ngayLeDtoRequest))
                .build();
    }

    @DeleteMapping
    public ApiResponse<Integer> deleteNgayLe(@RequestParam String tenNgayLe) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(ngayLeService.deleteNgayLe(tenNgayLe))
                .build();
    }
}
