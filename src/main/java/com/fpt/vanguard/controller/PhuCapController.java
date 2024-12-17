package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.dto.request.PhuCapDtoRequest;
import com.fpt.vanguard.dto.response.PhuCapDtoResponse;
import com.fpt.vanguard.service.PhuCapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/allowance")
@RequiredArgsConstructor
@CrossOrigin
public class PhuCapController {
    private final PhuCapService phuCapService;

    @GetMapping
    public ApiResponse<List<PhuCapDtoResponse>> getAllPhuCaps() {
        return ApiResponse.<List<PhuCapDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(phuCapService.getAllPhuCaps())
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> savePhuCap(@RequestBody PhuCapDtoRequest phuCapDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(phuCapService.savePhuCap(phuCapDtoRequest))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deletePhuCap(@PathVariable("id") String maPhuCap) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(phuCapService.deletePhuCap(maPhuCap))
                .build();
    }


}