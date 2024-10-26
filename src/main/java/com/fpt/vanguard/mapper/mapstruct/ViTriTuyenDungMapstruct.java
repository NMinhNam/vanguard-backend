package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.ViTriTuyenDungDtoRequest;
import com.fpt.vanguard.dto.response.ViTriTuyenDungDtoResponse;
import com.fpt.vanguard.entity.ViTriTuyenDung;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ViTriTuyenDungMapstruct {
    ViTriTuyenDung toTuyenDung(ViTriTuyenDungDtoRequest tuyenDung);
    ViTriTuyenDungDtoResponse toTuyenDungDtoResponse(ViTriTuyenDung tuyenDung);
    List<ViTriTuyenDungDtoResponse> toDtoResponseList(List<ViTriTuyenDung> tuyenDung);
}
