package com.fpt.vanguard.controller;

import com.fpt.vanguard.mapper.mybatis.ChucVuMapper;
import com.fpt.vanguard.service.NhanVienService;
import com.fpt.vanguard.service.PDFService;
import com.fpt.vanguard.service.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeCardController {
    private final NhanVienService nhanVienService;
    private final QRCodeService qrCodeService;
    private final PDFService pdfService;
    private final ChucVuMapper chucVuMapper;

    @GetMapping("/generate-employee-card-pdf")
    public ResponseEntity<byte[]> generateEmployeeCardPdf(@RequestParam String employeeCode) throws Exception {
        String tenChucVu = chucVuMapper.getTenChucVuByMaNhanVien(employeeCode);
        String tenNhanVien = nhanVienService.getNhanVienById(employeeCode).getHoTen();

        byte[] pdfContent = pdfService.generateEmployeeCardPdf(employeeCode, tenNhanVien, tenChucVu);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employee-card.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(pdfContent.length));

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}
