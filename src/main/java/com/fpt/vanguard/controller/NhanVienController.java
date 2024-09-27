package com.fpt.vanguard.controller;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.ApiResponse;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {
    private final NhanVienService nhanVienService;

    @GetMapping("/getAllNhanVien")
    public ApiResponse<List<NhanVienDtoResponse>> getAllNhanVien() {
        ApiResponse<List<NhanVienDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.getAllNhanVien());
        return apiResponse;
    }

    @GetMapping("/getNhanVienById")
    public ApiResponse<NhanVienDtoResponse> getNhanVienById(@RequestParam(name = "id") String id) {
        ApiResponse<NhanVienDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.getNhanVienById(id));
        return apiResponse;
    }

    @GetMapping("/getNhanVien")
    public ApiResponse<NhanVienDtoResponse> getNhanVien(NhanVienDtoRequest nhanVienDtoRequest) {
        ApiResponse<NhanVienDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.getNhanVien(nhanVienDtoRequest));
        return apiResponse;
    }

    @PostMapping("/saveNhanVien")
    public ApiResponse<Integer> saveNhanVien(@RequestBody NhanVienDtoRequest nhanVienDtoRequest) {
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.saveNhanVien(nhanVienDtoRequest));
        return apiResponse;
    }
}
