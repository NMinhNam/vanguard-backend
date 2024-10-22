package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.TrinhDoDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/educations")
@RequiredArgsConstructor
@CrossOrigin
public class TrinhDoController {


    @GetMapping
    public ApiResponse<List<TrinhDoDtoResponse>> getAllTrinhDo() {
        return null;
    }
}
