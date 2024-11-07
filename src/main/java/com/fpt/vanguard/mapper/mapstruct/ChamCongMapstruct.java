package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.ChamCongDtoRequest;
import com.fpt.vanguard.dto.response.ChamCongDtoResponse;
import com.fpt.vanguard.entity.BangChamCong;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChamCongMapstruct {
    List<ChamCongDtoResponse> toDtoResponseList(List<BangChamCong> bangChamCongList);
    BangChamCong toChamCong(ChamCongDtoRequest request);
}
