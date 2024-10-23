package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.DonYeuCauDtoResponse;

import java.util.List;

public interface DonYeuCauService {
    List<DonYeuCauDtoResponse> getDonYeuCau(String maNhanVien);
}
