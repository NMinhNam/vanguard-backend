package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.NghiPhepNamDtoRequest;
import com.fpt.vanguard.dto.response.NghiPhepNamDtoResponse;
import com.fpt.vanguard.entity.NghiPhepNam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NghiPhepNamMapstruct {
    NghiPhepNamDtoResponse toDtoResponse(NghiPhepNam nghiPhepNam);
    NghiPhepNam toNghiPhepNam(NghiPhepNamDtoRequest nghiPhepNamDtoRequest);
}
