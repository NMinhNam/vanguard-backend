package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.BangLuongDtoResponse;
import com.fpt.vanguard.dto.response.DonYeuCauDtoResponse;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;

import java.util.List;

public interface ThongKeService {
    List<PhongBanDtoResponse> getSoLuongNhanVienTheoPhongBan();
    List<DonYeuCauDtoResponse> getDonYeuCau();
    List<BangLuongDtoResponse> getSoLuongNhanVienTheoMucLuong();
    List<PhongBanDtoResponse> getTongLuongTheoPhongBan();
}
