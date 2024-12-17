package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.LoaiCongDtoRequest;
import com.fpt.vanguard.dto.response.LoaiCongDtoResponse;
import com.fpt.vanguard.entity.LoaiCong;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoaiCongMapstruct {
    List<LoaiCongDtoResponse> toDtoList(List<LoaiCong> loaiCongList);
    LoaiCong toLoaiCong(LoaiCongDtoRequest loaiCongDtoRequest);
    LoaiCongDtoResponse toDtoResponse(LoaiCong loaiCong);
}
