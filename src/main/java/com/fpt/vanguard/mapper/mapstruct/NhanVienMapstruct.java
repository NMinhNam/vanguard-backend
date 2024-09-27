package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.entity.NhanVien;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NhanVienMapstruct {
    NhanVien toNhanVien(NhanVienDtoRequest nhanVien);

    NhanVienDtoResponse toNhanVienDtoResponse(NhanVien nhanVien);
}
