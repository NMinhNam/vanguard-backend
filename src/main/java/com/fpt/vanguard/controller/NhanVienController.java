package com.fpt.vanguard.controller;

import com.fpt.vanguard.entity.NhanVien;
import com.fpt.vanguard.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/nhan-vien")
@RequiredArgsConstructor
@Slf4j
public class NhanVienController {
    private final NhanVienService nhanVienService;

    @GetMapping("/get-all-nhan-vien")
    public ResponseEntity<?> getAllNhanVien() {
        Map<String, Object> resultApi = new HashMap<>();
        try {
            resultApi.put("Data", nhanVienService.getAllNhanVien());
            resultApi.put("Success", Boolean.TRUE);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultApi.put("Success", Boolean.FALSE);
        }
        return ResponseEntity.ok(resultApi);
    }
}
