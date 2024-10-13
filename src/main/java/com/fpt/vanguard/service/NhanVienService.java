package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;

import java.text.ParseException;
import java.util.List;

public interface NhanVienService {
    List<NhanVienDtoResponse> getAllNhanVien();

    NhanVienDtoResponse getNhanVienById(String id);

    NhanVienDtoResponse getNhanVien(NhanVienDtoRequest nhanVienDtoRequest) throws ParseException;

    Integer saveNhanVien(NhanVienDtoRequest nhanVienDtoRequest);

    Integer deleteNhanVien(String id);
}
