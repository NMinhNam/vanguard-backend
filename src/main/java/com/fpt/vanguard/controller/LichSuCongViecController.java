package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.LichSuCongViecDtoResponse;
import com.fpt.vanguard.service.LichSuCongViecService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/work-histories")
@RequiredArgsConstructor
@CrossOrigin
public class LichSuCongViecController {
    private final LichSuCongViecService lichSuCongViecService;

    @GetMapping
    public ApiResponse<List<LichSuCongViecDtoResponse>> getLichSuCongViec
            (@RequestParam("maNhanVien") String maNhanVien) {
        return ApiResponse.<List<LichSuCongViecDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(lichSuCongViecService.getLichSuCongViecByMaNhanVien(maNhanVien))
                .build();
    }
}
