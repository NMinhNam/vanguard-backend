package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.UngVienDtoRequest;
import com.fpt.vanguard.dto.response.UngVienDtoResponse;

import java.util.List;

public interface UngVienService {
    List<UngVienDtoResponse> getUngVien(String tenViTri);

    int saveUngVien(UngVienDtoRequest ungVienDtoRequest);

    int insertUngVien(UngVienDtoRequest ungVienDtoRequest);

    int updateUngVien(UngVienDtoRequest ungVienDtoRequest);
}
