package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.ChamCongDtoRequest;
import com.fpt.vanguard.dto.response.ChamCongDtoResponse;

import java.util.List;

public interface ChamCongService {
    Integer doCheckIn(ChamCongDtoRequest request);

    Integer doCheckOut(ChamCongDtoRequest request);

    List<ChamCongDtoResponse> getChamCongNhanVien(String maNhanVien);

    List<ChamCongDtoResponse> getAllChamCong();

    ChamCongDtoResponse getChamCongDetail(ChamCongDtoRequest request);
}
