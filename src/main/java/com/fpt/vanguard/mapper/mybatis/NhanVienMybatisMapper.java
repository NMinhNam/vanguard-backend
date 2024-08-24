package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.entity.NhanVien;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NhanVienMybatisMapper {
    List<NhanVien> findAll();

    NhanVien findById(String id);

    NhanVien findNhanVien(@Param("nhanVien") NhanVienDtoRequest nhanVienDtoRequest);

    NhanVien insertNhanVien(@Param("nhanVien") NhanVienDtoRequest nhanVienDtoRequest);

    NhanVien updateNhanVien(@Param("nhanVien") NhanVienDtoRequest nhanVienDtoRequest);

    Boolean existsById(String id);
}
