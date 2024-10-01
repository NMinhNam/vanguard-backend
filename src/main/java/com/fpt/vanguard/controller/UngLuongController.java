package com.fpt.vanguard.controller;

import com.fpt.vanguard.dto.request.UngLuongDtoRequest;
import com.fpt.vanguard.dto.response.ApiResponse;
import com.fpt.vanguard.dto.response.UngLuongDtoResponse;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.service.UngLuongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ung-luong")
@RequiredArgsConstructor
public class UngLuongController {
    private final UngLuongService ungLuongService;

    @GetMapping("/getAllUngLuong")
    public ApiResponse<List<UngLuongDtoResponse>> getAllUngLuong() {
        ApiResponse<List<UngLuongDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.getAllUngLuong());
        return apiResponse;
    }

    @GetMapping("/getUngLuongById")
    public ApiResponse<UngLuongDtoResponse> getUngLuongById(@RequestParam(name = "id") String id) {
        ApiResponse<UngLuongDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.getUngLuongById(id));
        return apiResponse;
    }

    @GetMapping("/getUngLuong")
    public ApiResponse<UngLuongDtoResponse> getUngLuong(UngLuongDtoRequest ungLuongDtoRequest) {
        ApiResponse<UngLuongDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.getUngLuong(ungLuongDtoRequest));
        return apiResponse;
    }

    @PostMapping("/saveUngLuong")
    public ApiResponse<Integer> saveUngLuong(@RequestBody UngLuongDtoRequest ungLuongDtoRequest){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.saveUngLuong(ungLuongDtoRequest));
        return apiResponse;
    }

    @DeleteMapping("/deleteUngLuong")
    public ApiResponse<Integer> deleteUngLuong(@RequestParam("maUngLuong") String maUngLuong){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.deleteUngLuong(maUngLuong));
        return apiResponse;
    }
}
