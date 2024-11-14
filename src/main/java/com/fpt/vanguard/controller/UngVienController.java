package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.UngVienDtoRequest;
import com.fpt.vanguard.dto.response.UngVienDtoResponse;
import com.fpt.vanguard.service.UngVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ung-vien")
@RequiredArgsConstructor
@CrossOrigin
public class UngVienController {
    private final UngVienService ungVienService;

    @GetMapping
    public ApiResponse<List<UngVienDtoResponse>> getUngVien(@RequestParam("tenViTri") String tenViTri) {
        return ApiResponse.<List<UngVienDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(ungVienService.getUngVien(tenViTri))
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> saveUngVien(@RequestBody UngVienDtoRequest ungVienDtoRequest){
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(ungVienService.saveUngVien(ungVienDtoRequest))
                .build();
    }
}
