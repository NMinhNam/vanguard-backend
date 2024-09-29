package com.fpt.vanguard.controller;

import com.fpt.vanguard.dto.request.PhongBanDtoRequest;
import com.fpt.vanguard.dto.response.ApiResponse;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.service.PhongBanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phong_ban")
@RequiredArgsConstructor
public class PhongBanController {
    private final PhongBanService phongBanService;

    @GetMapping("/getAllPhongBan")
    public ApiResponse<List<PhongBanDtoResponse>> getAllPhongBan() {
        ApiResponse<List<PhongBanDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(phongBanService.getAllPhongBan());
        apiResponse.setSuccess(true);
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        return apiResponse;
    }

    @GetMapping("/getPhongBanByMaPhongBan")
    public ApiResponse<PhongBanDtoResponse> getPhongBanByMaPhongBan(@RequestParam("maPhongBan") String maPhongBan) {
        ApiResponse<PhongBanDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(phongBanService.findPhongBanByMaPhongBan(maPhongBan));
        apiResponse.setSuccess(true);
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        return apiResponse;
    }

    @PostMapping("/savePhongBan")
    public ApiResponse<Integer> savePhongBan(@RequestBody PhongBanDtoRequest phongBan){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(phongBanService.savePhongBan(phongBan));
        return apiResponse;
    }

    @DeleteMapping("/deletePhongBan")
    public ApiResponse<Integer> deletePhongBan(@RequestParam("maPhongBan") String maPhongBan){
        ApiResponse<Integer> apiResponse =new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(phongBanService.deletePhongBan(maPhongBan));
        return apiResponse;
    }
}
