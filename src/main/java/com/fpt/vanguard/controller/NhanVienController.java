package com.fpt.vanguard.controller;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
@CrossOrigin
public class NhanVienController {
    private final NhanVienService nhanVienService;

    @GetMapping
    public ApiResponse<List<NhanVienDtoResponse>> getAllNhanVien() {
        return ApiResponse.<List<NhanVienDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(nhanVienService.getAllNhanVien())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<NhanVienDtoResponse> getNhanVienById(@PathVariable("id") String id) {
        ApiResponse<NhanVienDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.getNhanVienById(id));
        return apiResponse;
    }

    @PostMapping("/search")
    public ApiResponse<NhanVienDtoResponse> getNhanVien(@RequestBody NhanVienDtoRequest nhanVienDtoRequest) throws ParseException {
        ApiResponse<NhanVienDtoResponse> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.getNhanVien(nhanVienDtoRequest));
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<Integer> saveNhanVien(@RequestBody NhanVienDtoRequest nhanVienDtoRequest) {
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.saveNhanVien(nhanVienDtoRequest));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteNhanVien(@PathVariable("id") String id) {
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.deleteNhanVien(id));
        return apiResponse;
    }
}
