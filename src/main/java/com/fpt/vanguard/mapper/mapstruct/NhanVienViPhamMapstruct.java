package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.NhanVienViPhamDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienViPhamDtoResponse;
import com.fpt.vanguard.entity.NhanVienViPham;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NhanVienViPhamMapstruct {
    NhanVienViPham toNhanVienViPham(NhanVienViPhamDtoRequest nhanVienViPhamDtoRequest);
    NhanVienViPhamDtoResponse toNhanVienViPhamDtoResponse(NhanVienViPham nhanVienViPham);
    List<NhanVienViPhamDtoResponse> toListNhanVienViPhamDtoResponse(List<NhanVienViPham> listNhanVienViPham);
}
