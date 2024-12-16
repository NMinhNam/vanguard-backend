package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.PhuCapDtoRequest;
import com.fpt.vanguard.dto.response.PhuCapDtoResponse;

import java.util.List;

public interface PhuCapService {
    List<PhuCapDtoResponse> getAllPhuCaps();
    Integer savePhuCap(PhuCapDtoRequest phuCapDtoRequest);
    Integer deletePhuCap(String maPhuCap);
    PhuCapDtoResponse getNhanVienPhuCap(PhuCapDtoRequest phuCapDtoRequest);
    Double getSumNhanVienPhuCapByMonth(String maNhanVien, Integer thang, Integer nam);
}
