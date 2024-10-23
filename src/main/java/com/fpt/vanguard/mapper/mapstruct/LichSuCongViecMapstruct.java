package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.response.LichSuCongViecDtoResponse;
import com.fpt.vanguard.entity.LichSuCongViec;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LichSuCongViecMapstruct {
    List<LichSuCongViecDtoResponse> toDtoResponseList(List<LichSuCongViec> lichSuCongViecList);
}
