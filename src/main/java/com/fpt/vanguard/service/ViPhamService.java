package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.ViPhamDtoRequest;
import com.fpt.vanguard.dto.response.ViPhamDtoResponse;

import java.util.List;

public interface ViPhamService {
    List<ViPhamDtoResponse> getAllViPhams();
    Integer saveViPham(ViPhamDtoRequest viPhamDtoRequest);
    Integer deleteViPham(String maViPham);
    Double getSumNhanVienViPhamByMonth(String maNhanVien, Integer thang, Integer nam);
}
