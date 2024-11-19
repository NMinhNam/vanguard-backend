package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.UngVienDtoRequest;
import com.fpt.vanguard.dto.response.UngVienDtoResponse;
import com.fpt.vanguard.service.UngVienService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @GetMapping("/search")
    public ApiResponse<UngVienDtoResponse> getUngVienByMaUngVien(@RequestParam("maUngVien") String maUngVien) {
        return ApiResponse.<UngVienDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(ungVienService.getUngVienByMaUngVien(maUngVien))
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> saveUngVien(@RequestBody UngVienDtoRequest ungVienDtoRequest) throws MessagingException, ParseException {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(ungVienService.saveUngVien(ungVienDtoRequest))
                .build();
    }
    @DeleteMapping("/{maUngVien}")
    public ApiResponse<Integer> deleteUngVien(@PathVariable("maUngVien") String maUngVien){
        ApiResponse<Integer> apiResponse =new ApiResponse<>();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setSuccess(true);
        apiResponse.setData(ungVienService.deleteUngVien(maUngVien));
        return apiResponse;
    }
}
