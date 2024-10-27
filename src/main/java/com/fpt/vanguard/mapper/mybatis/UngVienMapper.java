package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.UngVien;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UngVienMapper {
    List<UngVien> findAll(@Param("tenViTri") String tenViTri);
}
