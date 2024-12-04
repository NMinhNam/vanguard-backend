package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.ViTriTuyenDungDtoRequest;
import com.fpt.vanguard.dto.response.ViTriTuyenDungDtoResponse;
import com.fpt.vanguard.service.TuyenDungService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recruitment-positions")
@RequiredArgsConstructor
@CrossOrigin
public class TuyenDungController {
    private final TuyenDungService tuyenDungService;

    @GetMapping
    public ApiResponse<List<ViTriTuyenDungDtoResponse>> getAllViTriTuyenDung() {
        ApiResponse<List<ViTriTuyenDungDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(tuyenDungService.getAllTuyenDung());
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }

    @GetMapping("/id")
    public ApiResponse<ViTriTuyenDungDtoResponse> getViTriTuyenDungById(@RequestParam("maTuyenDung") String maTuyenDung) {
        ApiResponse<ViTriTuyenDungDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(tuyenDungService.getTuyenDungById(maTuyenDung));
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<Integer> saveTuyenDung(@RequestBody ViTriTuyenDungDtoRequest tuyenDung){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(tuyenDungService.saveTuyenDung(tuyenDung));
        return apiResponse;
    }
}
