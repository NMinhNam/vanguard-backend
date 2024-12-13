package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.NhanVienViPhamDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienViPhamDtoResponse;
import com.fpt.vanguard.dto.response.ViPhamDtoResponse;
import com.fpt.vanguard.service.NhanVienViPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee-violation")
@RequiredArgsConstructor
@CrossOrigin
public class NhanVienViPhamController {
    private final NhanVienViPhamService nhanVienViPhamService;
    @GetMapping
    public ApiResponse<List<NhanVienViPhamDtoResponse>> getAllNhanVienViPham() {
        return ApiResponse.<List<NhanVienViPhamDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(nhanVienViPhamService.getAllNhanVienViPham())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<List<NhanVienViPhamDtoResponse>> getNhanVienViPhamById(@PathVariable("id") String maNhanVien) {
        return ApiResponse.<List<NhanVienViPhamDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(nhanVienViPhamService.getNhanVienViPhamByNhanVienId(maNhanVien))
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> getNhanVienViPhamById(@RequestBody NhanVienViPhamDtoRequest nhanVienViPhamDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(nhanVienViPhamService.insertNhanVienViPham(nhanVienViPhamDtoRequest))
                .build();
    }
}
