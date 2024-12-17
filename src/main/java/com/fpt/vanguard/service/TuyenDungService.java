package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.ViTriTuyenDungDtoRequest;
import com.fpt.vanguard.dto.response.ViTriTuyenDungDtoResponse;

import java.util.List;

public interface TuyenDungService {
    List<ViTriTuyenDungDtoResponse> getAllTuyenDung();
    ViTriTuyenDungDtoResponse getTuyenDungById(String maTuyenDung);
    int saveTuyenDung(ViTriTuyenDungDtoRequest tuyenDung);
    String getMaViTriByTenViTri(String tenViTri);
}
