package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.ChucVuDtoRequest;
import com.fpt.vanguard.dto.request.ViTriTuyenDungDtoRequest;
import com.fpt.vanguard.dto.response.ChucVuDtoResponse;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;

import java.util.List;

public interface ChucVuService {
    List<ChucVuDtoResponse> getAllChucVu();

    ChucVuDtoResponse findChucVuByMaChucVu(String maChucVu);

    int saveChucVu(ChucVuDtoRequest chucVu);

    int deleteChucVu(String id);

}
