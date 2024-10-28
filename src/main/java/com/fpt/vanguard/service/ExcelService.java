package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ExcelService {
    List<NhanVienDtoResponse> getNhanVienFromExcel(MultipartFile file) throws IOException;
}
