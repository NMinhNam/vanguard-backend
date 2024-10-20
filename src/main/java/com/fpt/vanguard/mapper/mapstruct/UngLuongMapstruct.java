package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.UngLuongDtoRequest;
import com.fpt.vanguard.dto.response.UngLuongDtoResponse;
import com.fpt.vanguard.entity.UngLuong;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UngLuongMapstruct {
    UngLuong toUngLuong(UngLuongDtoRequest ungLuong);

    UngLuongDtoResponse toUngLuongDtoResponse(UngLuong ungLuong);
}
