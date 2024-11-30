package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.UngVienDtoRequest;
import com.fpt.vanguard.dto.response.UngVienDtoResponse;
import com.fpt.vanguard.entity.UngVien;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UngVienMapstruct {
    List<UngVienDtoResponse> toUngVienDtoResponseList(List<UngVien> ungVien);
    UngVienDtoResponse toUngVienDtoResponse(UngVien ungVien);
    UngVien toUngVien(UngVienDtoRequest ungVienDtoRequest);
}
