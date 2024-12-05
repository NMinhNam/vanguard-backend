package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.HopDongDtoRequest;
import com.fpt.vanguard.dto.response.HopDongDtoResponse;
import com.fpt.vanguard.entity.HopDong;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface HopDongMapstruct {
    List<HopDongDtoResponse> toHopDongDtoResponseList(List<HopDong> hopDong);
    HopDongDtoResponse toHopDongDtoResponse(HopDong hopDong);
    HopDong toHopDong(HopDongDtoRequest hopDongDtoRequest);
}
