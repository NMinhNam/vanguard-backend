package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.HocVanDtoResponse;
import com.fpt.vanguard.service.HocVanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/educations")
@RequiredArgsConstructor
@CrossOrigin
public class HocVanController {
    private final HocVanService hocVanService;

    @GetMapping
    public ApiResponse<List<HocVanDtoResponse>> getAllHocVan() {
        return ApiResponse.<List<HocVanDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(hocVanService.getAllHocVan())
                .build();
    }
}
