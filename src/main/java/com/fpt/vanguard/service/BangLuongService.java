package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.BangLuongDtoResponse;

import java.util.List;

public interface BangLuongService {
    List<BangLuongDtoResponse> getBangLuongNhanVien();
    List<BangLuongDtoResponse> getAllBangLuong();
    BangLuongDtoResponse getBangLuongNhanVienByMonth();
    Integer updateBangLuong();
}
