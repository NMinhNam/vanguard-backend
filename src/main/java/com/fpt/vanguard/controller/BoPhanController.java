package com.fpt.vanguard.controller;

import com.fpt.vanguard.dto.request.BoPhanDtoRequest;
import com.fpt.vanguard.dto.response.ApiResponse;
import com.fpt.vanguard.dto.response.BoPhanDtoResponse;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.service.BoPhanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bo_phan")
@RequiredArgsConstructor
public class BoPhanController {
    private final BoPhanService boPhanService;

    @GetMapping("/getAllBoPhan")
    public ApiResponse<List<BoPhanDtoResponse>> getAllBoPhan() {
        ApiResponse<List<BoPhanDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(boPhanService.getAllBoPhan());
        apiResponse.setSuccess(true);
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        return apiResponse;
    }

    @GetMapping("/getBoPhanByMaBoPhan")
    public ApiResponse<BoPhanDtoResponse> getBoPhanByMaBoPhan(@RequestParam("maBoPhan") String maBoPhan) {
        ApiResponse<BoPhanDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(boPhanService.findBoPhanByMaBoPhan(maBoPhan));
        apiResponse.setSuccess(true);
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        return apiResponse;
    }

    @PostMapping("/saveBoPhan")
    public ApiResponse<Integer> saveBoPhan(@RequestBody BoPhanDtoRequest boPhan){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(boPhanService.saveBoPhan(boPhan));
        return apiResponse;
    }

    @DeleteMapping("/deleteBoPhan")
    public ApiResponse<Integer> deleteBoPhan(@RequestParam("maBoPhan") String maBoPhan){
        ApiResponse<Integer> apiResponse =new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.HTTP_STATUS_200.getStatus());
        apiResponse.setSuccess(true);
        apiResponse.setData(boPhanService.deleteBoPhan(maBoPhan));
        return apiResponse;
    }
}
