package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.BoPhanDtoRequest;
import com.fpt.vanguard.dto.request.TuyenDungDtoRequest;
import com.fpt.vanguard.dto.response.BoPhanDtoResponse;
import com.fpt.vanguard.dto.response.TuyenDungDtoResponse;
import com.fpt.vanguard.service.TuyenDungService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tuyen-dung")
@RequiredArgsConstructor
@CrossOrigin
public class TuyenDungController {
    private final TuyenDungService tuyenDungService;

    @GetMapping
    public ApiResponse<List<TuyenDungDtoResponse>> getAllTuyenDung() {
        ApiResponse<List<TuyenDungDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(tuyenDungService.getAllTuyenDung());
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }
    @GetMapping("/search")
    public ApiResponse<TuyenDungDtoResponse> getTuyenDungById(@RequestParam("maTuyenDung") String maTuyenDung) {
        ApiResponse<TuyenDungDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(tuyenDungService.getTuyenDungById(maTuyenDung));
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }
    @PostMapping("/post")
    public ApiResponse<Integer> saveTuyenDung(@RequestBody TuyenDungDtoRequest tuyenDung){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(tuyenDungService.saveTuyenDung(tuyenDung));
        return apiResponse;
    }

}
