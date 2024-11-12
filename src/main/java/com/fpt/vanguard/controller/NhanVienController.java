package com.fpt.vanguard.controller;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.service.NhanVienService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("/me")
    public ApiResponse<NhanVienDtoResponse> getInfoNhanVien
            (@RequestParam("username") String username) {
        return ApiResponse.<NhanVienDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(nhanVienService.getNhanVienByUserName(username))
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> saveNhanVien(@RequestBody NhanVienDtoRequest nhanVienDtoRequest)
            throws MessagingException, ParseException {
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.createNhanVien(nhanVienDtoRequest));
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

    @PutMapping
    public ApiResponse<Integer> updateNhanVien(@RequestBody NhanVienDtoRequest nhanVienDtoRequest) throws MessagingException, ParseException, IOException {
        ApiResponse<Integer> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(nhanVienService.updateNhanVien(nhanVienDtoRequest));
        return apiResponse;
    }

    @GetMapping("orgchart")
    public ApiResponse<List<NhanVienDtoResponse>> getOrgChartNhanVien() {
        return ApiResponse.<List<NhanVienDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(nhanVienService.getOrgChartNhanVien())
                .build();
    }
}
