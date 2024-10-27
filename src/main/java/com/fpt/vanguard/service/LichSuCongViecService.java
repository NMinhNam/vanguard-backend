package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.LichSuCongViecDtoResponse;

import java.util.List;

public interface LichSuCongViecService {
    List<LichSuCongViecDtoResponse> getLichSuCongViecByMaNhanVien(String maNhanVien);
}
