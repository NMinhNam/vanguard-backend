package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.DonYeuCauDtoRequest;
import com.fpt.vanguard.dto.response.DonYeuCauDtoResponse;
import com.fpt.vanguard.service.DonYeuCauService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/don-yeu-cau")
@RequiredArgsConstructor
@CrossOrigin
public class DonYeuCauController {
    private final DonYeuCauService donYeuCauService;

    @GetMapping
    public ApiResponse<List<DonYeuCauDtoResponse>> getByMaNhanVien
            (@RequestParam("maNhanVien") String maNhanVien) {
        return ApiResponse.<List<DonYeuCauDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(donYeuCauService.getDonYeuCauByMaNhanVien(maNhanVien))
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> createDonYeuCau(@RequestBody DonYeuCauDtoRequest request) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(donYeuCauService.createDonYeuCau(request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteDonYeuCau(@PathVariable("id") String maDon) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(donYeuCauService.deleteDonYeuCau(maDon))
                .build();
    }

    @GetMapping("/employees")
    public ApiResponse<List<DonYeuCauDtoResponse>> getDonYeuCauToNhanVien() {
        return ApiResponse.<List<DonYeuCauDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(donYeuCauService.getAllDonYeuCau())
                .build();
    }

    @PutMapping
    public ApiResponse<Integer> updateDonYeuCau(@RequestBody DonYeuCauDtoRequest request) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(donYeuCauService.updateDonYeuCau(request))
                .build();
    }
}
