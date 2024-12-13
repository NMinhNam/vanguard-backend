package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.NhanVienViPhamDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienViPhamDtoResponse;

import java.util.List;

public interface NhanVienViPhamService {
    List<NhanVienViPhamDtoResponse> getAllNhanVienViPham();
    List<NhanVienViPhamDtoResponse> getNhanVienViPhamByNhanVienId(String maNhanVien);
    Integer insertNhanVienViPham(NhanVienViPhamDtoRequest nhanVienViPhamDtoRequest);
}
