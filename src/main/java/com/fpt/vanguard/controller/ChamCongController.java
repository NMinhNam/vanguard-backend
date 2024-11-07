package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.ChamCongDtoRequest;
import com.fpt.vanguard.service.ChamCongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/attendances")
@RequiredArgsConstructor
@CrossOrigin
public class ChamCongController {
    private final ChamCongService chamCongService;

    @GetMapping
    public ApiResponse<?> getAttendance() {
        return null;
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

    @PostMapping("/approve")
    public ApiResponse<?> doApprove() {
        return null;
    }

    @GetMapping("/employess/{id}")
    public ApiResponse<?> getAttendanceByEmployessId(@PathVariable String maNhanVien) {
        return null;
    }

}
