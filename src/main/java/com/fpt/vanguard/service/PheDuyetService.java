package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.PheDuyetDtoRequest;
import com.fpt.vanguard.dto.response.PheDuyetDtoResponse;
import com.fpt.vanguard.entity.PheDuyet;

import java.util.List;

public interface PheDuyetService {
    List<PheDuyetDtoResponse> getPheDuyets(String maNhanVien);
    Integer createPheDuyet(PheDuyetDtoRequest request);
    Integer updatePheDuyet(PheDuyetDtoRequest request);
    Integer deletePheDuyet(String maDon);
}
