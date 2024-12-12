package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.NgayLeDtoRequest;
import com.fpt.vanguard.dto.response.NgayLeDtoResponse;
import com.fpt.vanguard.entity.NgayLe;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NgayLeMapstruct {
    List<NgayLeDtoResponse> toDtoList(List<NgayLe> ngayLeList);
    NgayLe toNgayLe(NgayLeDtoRequest ngayLeDtoRequest);
}
