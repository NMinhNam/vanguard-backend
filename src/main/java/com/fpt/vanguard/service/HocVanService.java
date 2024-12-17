package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.HocVanDtoRequest;
import com.fpt.vanguard.dto.response.HocVanDtoResponse;

import java.util.List;

public interface HocVanService {
    List<HocVanDtoResponse> getAllHocVan();
    List<HocVanDtoResponse> getHocVan(String maNhanVien);
    Integer saveHocVan(HocVanDtoRequest request);
    Integer deleteHocVan(HocVanDtoRequest request);
}
