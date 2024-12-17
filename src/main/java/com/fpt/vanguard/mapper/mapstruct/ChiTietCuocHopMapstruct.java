package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.entity.ChiTietCuocHop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChiTietCuocHopMapstruct {
    ChiTietCuocHop toChiTietCuocHop(CuocHopDtoRequest request);
}
