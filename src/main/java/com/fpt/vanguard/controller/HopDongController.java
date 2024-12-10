package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.HopDongDtoRequest;
import com.fpt.vanguard.dto.response.HopDongDtoResponse;
import com.fpt.vanguard.service.HopDongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contracts")
@RequiredArgsConstructor
@CrossOrigin
public class HopDongController {
    private final HopDongService hopDongService;

    @GetMapping
    public ApiResponse<List<HopDongDtoResponse>> getAllHopDong() {
        ApiResponse<List<HopDongDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setData(hopDongService.getAllHopDong());
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<Integer> saveHopDong(@RequestBody HopDongDtoRequest hopDongDtoRequest){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(hopDongService.saveHopDong(hopDongDtoRequest));
        return apiResponse;
    }

    @GetMapping("/id")
    public ApiResponse<HopDongDtoResponse> getHopDongById(@RequestParam(name = "id") String id) {
        ApiResponse<HopDongDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(hopDongService.getHopDongById(id));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteHopDong(@PathVariable("id") String id){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(hopDongService.deleteHopDong(id));
        return apiResponse;
    }
    @GetMapping("/employee/{maNhanVien}")
    public ApiResponse<List<HopDongDtoResponse>> getHopDongByMaNhanVien(@PathVariable("maNhanVien") String maNhanVien) {
        ApiResponse<List<HopDongDtoResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(hopDongService.getHopDongByMaNhanVien(maNhanVien));
        return apiResponse;
    }
}
