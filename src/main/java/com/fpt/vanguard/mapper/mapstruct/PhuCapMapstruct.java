package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.response.PhuCapDtoResponse;
import com.fpt.vanguard.entity.PhuCap;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhuCapMapstruct {
    List<PhuCapDtoResponse> toListDtoResponses(List<PhuCap> phuCaps);
}
