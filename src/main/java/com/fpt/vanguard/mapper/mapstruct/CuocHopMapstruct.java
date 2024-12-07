package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.dto.response.CuocHopDtoResponse;
import com.fpt.vanguard.entity.CuocHop;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuocHopMapstruct {
    List<CuocHopDtoResponse> toDtoList(List<CuocHop> cuocHopList);
    CuocHopDtoResponse toDtoResponse(CuocHop cuocHop);
    CuocHop toCuocHop(CuocHopDtoRequest cuocHopDtoRequest);
}
