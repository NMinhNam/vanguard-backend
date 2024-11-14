package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.PhongBanDtoRequest;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;

import java.util.List;

public interface PhongBanService {
    List<PhongBanDtoResponse> getAllPhongBan();

    PhongBanDtoResponse findPhongBanByMaPhongBan(String maPhongBan);

    int savePhongBan(PhongBanDtoRequest phongBan);

    int deletePhongBan(String maPhongBan);

    List<PhongBanDtoResponse> getOrgChart();
}
