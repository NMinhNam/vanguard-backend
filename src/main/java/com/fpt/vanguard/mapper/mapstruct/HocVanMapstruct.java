package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.response.HocVanDtoResponse;
import com.fpt.vanguard.entity.HocVan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HocVanMapstruct {
    List<HocVanDtoResponse> toHocVanDtoResponseList(List<HocVan> hocVanList);
}
