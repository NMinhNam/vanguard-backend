package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.PheDuyetDtoRequest;
import com.fpt.vanguard.dto.response.PheDuyetDtoResponse;
import com.fpt.vanguard.entity.PheDuyet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PheDuyetMapstruct {
    List<PheDuyetDtoResponse> toDtoList(List<PheDuyet> pheDuyets);
    PheDuyet toPheDuyet(PheDuyetDtoRequest request);
    PheDuyetDtoResponse toDto(PheDuyet pheDuyet);
}
