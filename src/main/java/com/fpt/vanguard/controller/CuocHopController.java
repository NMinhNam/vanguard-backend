package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.dto.response.CuocHopDtoResponse;
import com.fpt.vanguard.service.CuocHopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/meetings")
@RequiredArgsConstructor
@CrossOrigin
public class CuocHopController {
    private final CuocHopService cuocHopService;

    @GetMapping
    public ApiResponse<List<CuocHopDtoResponse>> getAllMeetings() {
        return ApiResponse.<List<CuocHopDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(cuocHopService.getAllCuocHops())
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> saveMeeting(@RequestBody CuocHopDtoRequest cuocHopDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(cuocHopService.saveCuocHop(cuocHopDtoRequest))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteMeeting(@PathVariable("id") String maCuocHop) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(cuocHopService.deleteCuocHop(maCuocHop))
                .build();
    }
}
