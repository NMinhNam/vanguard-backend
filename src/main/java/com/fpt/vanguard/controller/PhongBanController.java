package com.fpt.vanguard.controller;

import com.fpt.vanguard.dto.request.PhongBanDtoRequest;
import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;
import com.fpt.vanguard.service.PhongBanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
@RequiredArgsConstructor
@CrossOrigin
public class PhongBanController {
    private final PhongBanService phongBanService;

    @GetMapping
    public ApiResponse<List<PhongBanDtoResponse>> getAllPhongBan() {
        ApiResponse<List<PhongBanDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(phongBanService.getAllPhongBan());
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }

    @GetMapping("/{id}")
    public ApiResponse<PhongBanDtoResponse> getPhongBanById(@PathVariable("id") String maPhongBan) {
        ApiResponse<PhongBanDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(phongBanService.findPhongBanByMaPhongBan(maPhongBan));
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<Integer> savePhongBan(@RequestBody PhongBanDtoRequest phongBan){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(phongBanService.savePhongBan(phongBan));
        return apiResponse;
    }

    @DeleteMapping("/{maPhongBan}")
    public ApiResponse<Integer> deletePhongBan(@PathVariable("maPhongBan") String maPhongBan){
        ApiResponse<Integer> apiResponse =new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(phongBanService.deletePhongBan(maPhongBan));
        return apiResponse;
    }

    @GetMapping("/orgchart")
    public ApiResponse<List<PhongBanDtoResponse>> getOrgChartPhongBan(){
        return ApiResponse.<List<PhongBanDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(phongBanService.getOrgChart())
                .build();
    }
}
