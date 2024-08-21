package com.fpt.vanguard.controller;

import com.fpt.vanguard.dto.response.ApiResponse;
import com.fpt.vanguard.entity.NhanVien;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {
    private final NhanVienService nhanVienService;

    @GetMapping("/getAllNhanVien")
    public ApiResponse<List<NhanVien>> getAllNhanVien() {
        ApiResponse<List<NhanVien>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.getAllNhanVien());
        return apiResponse;
    }

    @GetMapping("/getByNhanVienId/{id}")
    public ApiResponse<Optional<NhanVien>> getNhanVienById(@PathVariable Integer id) {
        ApiResponse<Optional<NhanVien>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.getNhanVienById(id));
        return apiResponse;
    }
}
