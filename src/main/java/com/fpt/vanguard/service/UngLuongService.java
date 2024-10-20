package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.UngLuongDtoRequest;
import com.fpt.vanguard.dto.response.UngLuongDtoResponse;

import java.util.List;

public interface UngLuongService {
    List<UngLuongDtoResponse> getAllUngLuong();

    UngLuongDtoResponse getUngLuongById(String id);

    UngLuongDtoResponse getUngLuong(UngLuongDtoRequest ungLuongDtoRequest);

    int saveUngLuong(UngLuongDtoRequest ungLuongDtoRequest);

    int deleteUngLuong(String id);
}
