package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.TuyenDungDtoRequest;
import com.fpt.vanguard.dto.response.TuyenDungDtoResponse;
import com.fpt.vanguard.entity.TuyenDung;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TuyenDungMapstruct {
    TuyenDung toTuyenDung(TuyenDungDtoRequest tuyenDung);
    TuyenDungDtoResponse toTuyenDungDtoResponse(TuyenDung tuyenDung);
}
