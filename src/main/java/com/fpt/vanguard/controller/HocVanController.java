package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.HocVanDtoRequest;
import com.fpt.vanguard.dto.response.HocVanDtoResponse;
import com.fpt.vanguard.service.HocVanService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ApiResponse<List<HocVanDtoResponse>> getHocVan(@PathVariable("id") String maNhanVien) {
        return ApiResponse.<List<HocVanDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(hocVanService.getHocVan(maNhanVien))
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> saveHocVan(@RequestBody HocVanDtoRequest hocVanDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(hocVanService.saveHocVan(hocVanDtoRequest))
                .build();
    }

    @DeleteMapping
    public ApiResponse<Integer> deleteHocVan(@RequestBody HocVanDtoRequest hocVanDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(hocVanService.deleteHocVan(hocVanDtoRequest))
                .build();
    }
}
