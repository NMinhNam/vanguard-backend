package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.ChucVuDtoRequest;
import com.fpt.vanguard.dto.response.ChucVuDtoResponse;
import com.fpt.vanguard.entity.ChucVu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChucVuMapstruct {
    List<ChucVuDtoResponse> toDtoResponseList(List<ChucVu> chucVuList);
    ChucVu toChucVu(ChucVuDtoRequest request);
    ChucVuDtoResponse toChucVuDtoResponse(ChucVu chucVu);
}
