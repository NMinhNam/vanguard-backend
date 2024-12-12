package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.LoaiCongDtoRequest;
import com.fpt.vanguard.dto.response.LoaiCongDtoResponse;

import java.util.List;

public interface LoaiCongService {
    Integer getLoaiCong(String ngayChamCong);

    Integer saveLoaiCong(LoaiCongDtoRequest loaiCongDtoRequest);

    Integer deleteLoaiCong(String tenLoaiCong);

    List<LoaiCongDtoResponse> getAllLoaiCong();
}
