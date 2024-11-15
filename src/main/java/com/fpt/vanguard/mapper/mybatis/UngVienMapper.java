package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.UngVienDtoRequest;
import com.fpt.vanguard.entity.UngVien;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UngVienMapper {
    List<UngVien> findAll(@Param("tenViTri") String tenViTri);

    int insertUngVien(UngVien ungVien);

    int updateUngVien(UngVien ungVien);

    boolean isExistUngVien(@Param("maUngVien") String maUngVien);

    List<UngVien> getUngVienByViTriAndTrangThai(String viTri,int trangThai);

}
