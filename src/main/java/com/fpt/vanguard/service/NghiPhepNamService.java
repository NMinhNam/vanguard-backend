package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.NghiPhepNamDtoRequest;
import com.fpt.vanguard.dto.response.NghiPhepNamDtoResponse;

import java.time.LocalDate;

public interface NghiPhepNamService {
    NghiPhepNamDtoResponse getNgayNghiPhepNam(String maNhanVien);
    Integer updateNgayPhepKhiXinNghi(String maNhanVien, Integer soNgayNghi);
    Integer createNghiPhepNamChoNhanVienMoi(LocalDate ngayBatDau, NghiPhepNamDtoRequest nghiPhepNamDtoRequest);
    Integer updateNghiPhepNamChoNamMoi(NghiPhepNamDtoRequest nghiPhepNamDtoRequest);
}
