package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.entity.NhanVien;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NhanVienMapstruct {
    List<NhanVienDtoResponse> toNhanVienDtoResponseList(List<NhanVien> nhanVienList);

    NhanVien toNhanVien(NhanVienDtoRequest nhanVien);

    NhanVienDtoResponse toNhanVienDtoResponse(NhanVien nhanVien);

}
