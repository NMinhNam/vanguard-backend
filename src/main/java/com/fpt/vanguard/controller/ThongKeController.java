package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.response.*;
import com.fpt.vanguard.service.ThongKeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/statistic")
@RequiredArgsConstructor
@CrossOrigin
public class ThongKeController {
    private final ThongKeService thongKeService;

    @GetMapping("/departments")
    public ApiResponse<List<PhongBanDtoResponse>> getSoLuongNhanVienTheoPhongBan() {
        return ApiResponse.<List<PhongBanDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(thongKeService.getSoLuongNhanVienTheoPhongBan())
                .build();
    }

    @GetMapping("/leave-requests")
    public ApiResponse<List<DonYeuCauDtoResponse>> getDonNghiPhep() {
        return ApiResponse.<List<DonYeuCauDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(thongKeService.getDonYeuCau())
                .build();
    }

    @GetMapping("/salary-by-employee")
    public ApiResponse<List<BangLuongDtoResponse>> getMucLuongTheoSoNhanVien() {
        return ApiResponse.<List<BangLuongDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(thongKeService.getSoLuongNhanVienTheoMucLuong())
                .build();
    }

    @GetMapping("/salary-by-department")
    public ApiResponse<List<PhongBanDtoResponse>> getTongLuongTheoPhongBan() {
        return ApiResponse.<List<PhongBanDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(thongKeService.getTongLuongTheoPhongBan())
                .build();
    }

    @GetMapping("/employee-movement-by-department")
    public ApiResponse<List<PhongBanDtoResponse>> getBienDongNhanVienTheoPhongBan() {
        return ApiResponse.<List<PhongBanDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(thongKeService.getBienDongNhanVienTheoPhongBan())
                .build();
    }

    @GetMapping("/new-hires")
    public ApiResponse<List<NhanVienDtoResponse>> getNhanSuMoi() {
        return ApiResponse.<List<NhanVienDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(thongKeService.getNhanSuMoi())
                .build();
    }

    @GetMapping("/employees-birthday")
    public ApiResponse<List<NhanVienDtoResponse>> getNhanVienByBirthday() {
        return ApiResponse.<List<NhanVienDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(thongKeService.getNhanVienSinhNhat())
                .build();
    }

    @GetMapping("/education-by-employee")
    public ApiResponse<List<HocVanDtoResponse>> getSoLuongNhanVienTheoHocVan() {
        return ApiResponse.<List<HocVanDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(thongKeService.getSoLuongNhanVienTheoHocVan())
                .build();
    }

    @GetMapping("/salary/employee/{id}")
    public ApiResponse<List<BangLuongDtoResponse>> getTongLuongNhanVienTheoThang(@PathVariable("id") String maNhanVien) {
        return ApiResponse.<List<BangLuongDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(thongKeService.getTongLuongNhanVienTheoThang(maNhanVien))
                .build();
    }
}
