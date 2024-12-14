package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.BangLuongDtoResponse;

import java.util.List;

public interface BangLuongService {
    List<BangLuongDtoResponse> getBangLuongNhanVien(String maNhanVien);
    List<BangLuongDtoResponse> getAllBangLuong();
    Integer updateBangLuong();
}
