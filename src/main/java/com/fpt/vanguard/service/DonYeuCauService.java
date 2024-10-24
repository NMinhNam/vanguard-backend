package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.DonYeuCauDtoRequest;
import com.fpt.vanguard.dto.response.DonYeuCauDtoResponse;

import java.util.List;

public interface DonYeuCauService {
    List<DonYeuCauDtoResponse> getDonYeuCauByMaNhanVien(String maNhanVien);
    Integer createDonYeuCau(DonYeuCauDtoRequest request);
    Integer deleteDonYeuCau(String maDon);
    List<DonYeuCauDtoResponse> getAllDonYeuCau();
}
