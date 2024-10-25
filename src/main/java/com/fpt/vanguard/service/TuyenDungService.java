package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.TuyenDungDtoRequest;
import com.fpt.vanguard.dto.response.TuyenDungDtoResponse;


import java.util.List;

public interface TuyenDungService {
    List<TuyenDungDtoResponse> getAllTuyenDung();
    TuyenDungDtoResponse getTuyenDungById(String maTuyenDung);
    int saveTuyenDung(TuyenDungDtoRequest tuyenDung);
}
