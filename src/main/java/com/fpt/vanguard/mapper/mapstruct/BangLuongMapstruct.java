package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.response.BangLuongDtoResponse;
import com.fpt.vanguard.entity.BangLuong;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BangLuongMapstruct {
    List<BangLuongDtoResponse> toResponseList(List<BangLuong> bangLuongs);
    BangLuongDtoResponse toDtoResponse(BangLuong bangLuong);
}
