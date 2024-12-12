//package com.fpt.vanguard.controller;
//
//import com.fpt.vanguard.common.ApiResponse;
//import com.fpt.vanguard.dto.response.NghiPhepNamDtoResponse;
//import com.fpt.vanguard.service.NghiPhepNamService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/v1/annual-leave")
//@RequiredArgsConstructor
//@CrossOrigin
//public class NghiPhepNamController {
//    private final NghiPhepNamService nghiPhepNamService;
//
//    @GetMapping("/employee/{id}")
//    public ApiResponse<NghiPhepNamDtoResponse> getNgayNghiPhepNam(@PathVariable("id") String maNhanVien) {
//        return ApiResponse.<NghiPhepNamDtoResponse>builder()
//                .status(HttpStatus.OK.value())
//                .success(true)
//                .data(nghiPhepNamService.getNgayNghiPhepNam(maNhanVien))
//                .build();
//    }
//}
