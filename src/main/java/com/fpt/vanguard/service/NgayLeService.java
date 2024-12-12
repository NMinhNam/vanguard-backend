package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.NgayLeDtoRequest;
import com.fpt.vanguard.dto.response.NgayLeDtoResponse;

import java.util.List;

public interface NgayLeService {
    List<NgayLeDtoResponse> getAllNgayLe();
    Integer saveNgayLe(NgayLeDtoRequest ngayLeDtoRequest);
    Integer deleteNgayLe(String tenNgayLe);
}
