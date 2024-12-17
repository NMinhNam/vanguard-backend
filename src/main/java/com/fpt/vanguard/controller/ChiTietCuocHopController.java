package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.service.ChiTietCuocHopService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/chi-tiet-cuoc-hop")
@RequiredArgsConstructor
@CrossOrigin
public class ChiTietCuocHopController {
    private final ChiTietCuocHopService chiTietCuocHopService;

    @PostMapping
    public ApiResponse<Integer> addNhanVienToCuocHop(@RequestBody CuocHopDtoRequest cuocHopDtoRequest) throws MessagingException {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(chiTietCuocHopService.addNhanVienToCuocHop(cuocHopDtoRequest))
                .build();
    }
}
