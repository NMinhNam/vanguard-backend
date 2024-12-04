package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.ChucVuDtoRequest;
import com.fpt.vanguard.dto.response.ChucVuDtoResponse;
import com.fpt.vanguard.service.ChucVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/positions")
@RequiredArgsConstructor
@CrossOrigin
public class ChucVuController {
    private final ChucVuService chucVuService;

    @GetMapping
    public ApiResponse<List<ChucVuDtoResponse>> getAllChucVu() {
        return ApiResponse.<List<ChucVuDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(chucVuService.getAllChucVu())
                .build();
    }

    @GetMapping("/id")
    public ApiResponse<ChucVuDtoResponse> getChucVuByMaChucVu(@RequestParam("maChucVu") String maChucVu) {
        ApiResponse<ChucVuDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setData(chucVuService.findChucVuByMaChucVu(maChucVu));
        apiResponse.setSuccess(true);
        apiResponse.setStatus(HttpStatus.OK.value());
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<Integer> saveChucVu(@RequestBody ChucVuDtoRequest chucVuDtoRequest){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(chucVuService.saveChucVu(chucVuDtoRequest));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteUngLuong(@PathVariable("id") String id){
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(chucVuService.deleteChucVu(id));
        return apiResponse;
    }
}
