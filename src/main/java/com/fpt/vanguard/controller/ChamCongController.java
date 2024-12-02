package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.ChamCongDtoRequest;
import com.fpt.vanguard.dto.response.ChamCongDtoResponse;
import com.fpt.vanguard.service.ChamCongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attendances")
@RequiredArgsConstructor
@CrossOrigin
public class ChamCongController {
    private final ChamCongService chamCongService;

    @GetMapping
    public ApiResponse<List<ChamCongDtoResponse>> getAttendance() {
        return ApiResponse.<List<ChamCongDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(chamCongService.getAllChamCong())
                .build();
    }

    @PostMapping("/checkin")
    public ApiResponse<Integer> doCheckIn(@RequestBody ChamCongDtoRequest chamCongDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(chamCongService.doCheckIn(chamCongDtoRequest))
                .build();
    }

    @PostMapping("/checkout")
    public ApiResponse<?> doCheckOut(@RequestBody ChamCongDtoRequest chamCongDtoRequest) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(chamCongService.doCheckOut(chamCongDtoRequest))
                .build();
    }

    @GetMapping("/employess/{id}")
    public ApiResponse<List<ChamCongDtoResponse>> getAttendanceByEmployessId(@PathVariable("id") String maNhanVien) {
        return ApiResponse.<List<ChamCongDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(chamCongService.getChamCongNhanVien(maNhanVien))
                .build();
    }

    @GetMapping("today/{employeeId}")
    public ApiResponse<ChamCongDtoResponse> getAttendanceToDay(@PathVariable("employeeId") String maNhanVien) {
        return ApiResponse.<ChamCongDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(chamCongService.getChamCongToDay(maNhanVien))
                .build();
    }
}
