package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.*;

import java.util.List;

public interface ThongKeService {
    List<PhongBanDtoResponse> getSoLuongNhanVienTheoPhongBan();
    List<DonYeuCauDtoResponse> getDonYeuCau();
    List<BangLuongDtoResponse> getSoLuongNhanVienTheoMucLuong();
    List<PhongBanDtoResponse> getTongLuongTheoPhongBan();
    List<PhongBanDtoResponse> getBienDongNhanVienTheoPhongBan();
    List<NhanVienDtoResponse> getNhanSuMoi();
    List<NhanVienDtoResponse> getNhanVienSinhNhat();
    List<HocVanDtoResponse> getSoLuongNhanVienTheoHocVan();
    List<BangLuongDtoResponse> getTongLuongNhanVienTheoThang(String maNhanVien);
}
