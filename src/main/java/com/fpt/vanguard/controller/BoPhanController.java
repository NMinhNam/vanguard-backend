package com.fpt.vanguard.controller;

import com.fpt.vanguard.dto.request.BoPhanDtoRequest;
import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.BoPhanDtoResponse;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.service.BoPhanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bo_phan")
@RequiredArgsConstructor
public class BoPhanController {
    private final BoPhanService boPhanService;

    @GetMapping
    public ApiResponse<List<BoPhanDtoResponse>> getAllBoPhan() {
        ApiResponse<List<BoPhanDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(boPhanService.getAllBoPhan());
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }

    @GetMapping("/search")
    public ApiResponse<BoPhanDtoResponse> getBoPhanByMaBoPhan(@RequestParam("maBoPhan") String maBoPhan) {
        ApiResponse<BoPhanDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(boPhanService.findBoPhanByMaBoPhan(maBoPhan));
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<Integer> saveBoPhan(@RequestBody BoPhanDtoRequest boPhan){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(boPhanService.saveBoPhan(boPhan));
        return apiResponse;
    }

    @DeleteMapping("/{maBoPhan}")
    public ApiResponse<Integer> deleteBoPhan(@PathVariable("maBoPhan") String maBoPhan){
        ApiResponse<Integer> apiResponse =new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(boPhanService.deleteBoPhan(maBoPhan));
        return apiResponse;
    }
}
