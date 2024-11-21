package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.HopDongDtoRequest;
import com.fpt.vanguard.dto.response.HopDongDtoResponse;
import com.fpt.vanguard.dto.response.UngLuongDtoResponse;

import java.util.List;

public interface HopDongService {
    List<HopDongDtoResponse> getAllHopDong();

    int saveHopDong(HopDongDtoRequest hopdong);

    HopDongDtoResponse getHopDongById(String id);

    int deleteUngLuong(String id);
}
