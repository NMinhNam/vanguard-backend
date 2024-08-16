package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.entity.NhanVien;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nhan-vien")
@RequiredArgsConstructor
@Slf4j
public class NhanVienController {
    private final NhanVienService nhanVienService;

    @GetMapping("/get-all-nhan-vien")
    public ApiResponse<List<NhanVien>> getAllNhanVien() {
        ApiResponse<List<NhanVien>> apiResponse = new ApiResponse<>();
        try {
            apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
            apiResponse.setSuccess(true);
            apiResponse.setData(nhanVienService.getAllNhanVien());
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setMessage(e.getMessage());
        }
        return apiResponse;
    }
}
