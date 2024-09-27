package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.entity.NhanVien;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NhanVienMapstructMapper {
    NhanVien toNhanVien(NhanVienDtoRequest nhanVien);

    NhanVienDtoResponse toNhanVienDtoResponse(NhanVien nhanVien);
}
