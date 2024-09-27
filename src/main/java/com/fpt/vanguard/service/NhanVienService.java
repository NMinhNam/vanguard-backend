package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;

import java.util.List;

public interface NhanVienService {
    List<NhanVienDtoResponse> getAllNhanVien();

    NhanVienDtoResponse getNhanVienById(String id);

    NhanVienDtoResponse getNhanVien(NhanVienDtoRequest nhanVienDtoRequest);

    Integer saveNhanVien(NhanVienDtoRequest nhanVienDtoRequest);
}
