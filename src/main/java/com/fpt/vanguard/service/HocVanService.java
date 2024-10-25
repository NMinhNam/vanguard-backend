package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.HocVanDtoResponse;

import java.util.List;

public interface HocVanService {
    List<HocVanDtoResponse> getAllHocVan();
    List<HocVanDtoResponse> getHocVan(String maNhanVien);
}
