package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.WifiInfoDtoRequest;
import com.fpt.vanguard.dto.response.WifiInfoDtoResponse;
import com.fpt.vanguard.service.WifiAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wifi-info")
@RequiredArgsConstructor
@CrossOrigin
public class WifiConfigController {
    private final WifiAuthService wifiAuthService;

    @GetMapping
    public ApiResponse<List<WifiInfoDtoResponse>> getWifiList() {
        return ApiResponse.<List<WifiInfoDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(wifiAuthService.getWifiList())
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> saveWifiInfo(@RequestBody WifiInfoDtoRequest request) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(wifiAuthService.saveWifiInfo(request))
                .build();
    }
}
