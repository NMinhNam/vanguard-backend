package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.response.ViPhamDtoResponse;
import com.fpt.vanguard.entity.ViPham;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ViPhamMapstruct {
    List<ViPhamDtoResponse> toResponseList(List<ViPham> viPhams);
}
