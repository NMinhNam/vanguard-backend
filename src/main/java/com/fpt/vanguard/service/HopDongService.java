package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.HopDongDtoRequest;
import com.fpt.vanguard.dto.response.HopDongDtoResponse;


import java.util.List;

public interface HopDongService {
    List<HopDongDtoResponse> getAllHopDong();

    int saveHopDong(HopDongDtoRequest hopdong);

    HopDongDtoResponse getHopDongById(String id);

    int deleteHopDong(String id);

    List<HopDongDtoResponse> getListHopDongByMaNhanVien(String maNhanVien);

    HopDongDtoResponse getHopDongByMaNhanVien(String maNhanVien);
}
