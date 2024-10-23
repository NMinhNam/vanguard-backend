package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
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
    public ApiResponse<List<DonYeuCauDtoResponse>> getDonYeuCau
            (@RequestParam("maNhanVien") String maNhanVien) {
        return ApiResponse.<List<DonYeuCauDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(donYeuCauService.getDonYeuCau(maNhanVien))
                .build();
    }
}
