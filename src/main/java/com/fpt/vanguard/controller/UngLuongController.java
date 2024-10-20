package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.UngLuongDtoRequest;
import com.fpt.vanguard.dto.response.UngLuongDtoResponse;
import com.fpt.vanguard.service.UngLuongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ung-luong")
@RequiredArgsConstructor
@CrossOrigin
public class UngLuongController {
    private final UngLuongService ungLuongService;

    @GetMapping
    public ApiResponse<List<UngLuongDtoResponse>> getAllUngLuong() {
        ApiResponse<List<UngLuongDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.getAllUngLuong());
        return apiResponse;
    }

    @GetMapping("/search")
    public ApiResponse<UngLuongDtoResponse> getUngLuongById(@RequestParam(name = "id") String id) {
        ApiResponse<UngLuongDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.getUngLuongById(id));
        return apiResponse;
    }

    @GetMapping("/getUngLuong")
    public ApiResponse<UngLuongDtoResponse> getUngLuong(UngLuongDtoRequest ungLuongDtoRequest) {
        ApiResponse<UngLuongDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.getUngLuong(ungLuongDtoRequest));
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<Integer> saveUngLuong(@RequestBody UngLuongDtoRequest ungLuongDtoRequest){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.saveUngLuong(ungLuongDtoRequest));
        return apiResponse;
    }

    @DeleteMapping("/{maUngLuong}")
    public ApiResponse<Integer> deleteUngLuong(@PathVariable("maUngLuong") String maUngLuong){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungLuongService.deleteUngLuong(maUngLuong));
        return apiResponse;
    }
}
