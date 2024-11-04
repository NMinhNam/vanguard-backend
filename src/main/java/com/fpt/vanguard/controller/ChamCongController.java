package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.service.ChamCongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/attendance")
@RequiredArgsConstructor
@CrossOrigin
public class ChamCongController {
    private final ChamCongService chamCongService;

    

    @PostMapping("/checkin")
    public ApiResponse<?> doCheckIn() {
        return null;
    }

    @PostMapping("/checkout")
    public ApiResponse<?> doCheckOut() {
        return null;
    }

    @PostMapping("/approve")
    public ApiResponse<?> doApprove() {
        return null;
    }


}
