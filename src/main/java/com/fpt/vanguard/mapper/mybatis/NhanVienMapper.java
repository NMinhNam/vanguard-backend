package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.entity.NhanVien;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NhanVienMapper {
    List<NhanVien> findAll();

    NhanVien findById(String id);

    NhanVien findNhanVien(@Param("nhanVien") NhanVien nhanVien);

    int insertNhanVien(@Param("nhanVien") NhanVien nhanVien);

    int updateNhanVien(@Param("nhanVien") NhanVien nhanVien);

    boolean existsById(String id);
}
