package com.fpt.vanguard.service;

import com.fpt.vanguard.entity.NhanVien;

import java.util.List;
import java.util.Optional;

public interface NhanVienService {
    List<NhanVien> getAllNhanVien();

    Optional<NhanVien> getNhanVienById(Integer id);
}
