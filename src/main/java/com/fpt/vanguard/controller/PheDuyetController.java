package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.PheDuyetDtoRequest;
import com.fpt.vanguard.dto.response.PheDuyetDtoResponse;
import com.fpt.vanguard.service.PheDuyetService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/phe-duyet")
@RequiredArgsConstructor
@CrossOrigin
public class PheDuyetController {
    private final PheDuyetService pheDuyetService;

    @GetMapping("/{maNhanVien}")
    public ApiResponse<List<PheDuyetDtoResponse>> getPheDuyets
            (@PathVariable("maNhanVien") String maNhanVien) {
        return ApiResponse.<List<PheDuyetDtoResponse>>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(pheDuyetService.getPheDuyets(maNhanVien))
                .build();
    }

    @PostMapping
    public ApiResponse<Integer> createPheDuyet(@RequestBody PheDuyetDtoRequest pheDuyetDtoRequest) throws MessagingException {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(pheDuyetService.createPheDuyet(pheDuyetDtoRequest))
                .build();
    }

    @PutMapping
    public ApiResponse<Integer> updatePheDuyet(@RequestBody PheDuyetDtoRequest pheDuyetDtoRequest) throws MessagingException {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(pheDuyetService.updatePheDuyet(pheDuyetDtoRequest))
                .build();
    }

    @DeleteMapping("/{maDon}")
    public ApiResponse<Integer> deletePheDuyet
            (@PathVariable("maDon") String maDon) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(pheDuyetService.deletePheDuyet(maDon))
                .build();
    }
}
