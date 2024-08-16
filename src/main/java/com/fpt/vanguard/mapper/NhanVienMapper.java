package com.fpt.vanguard.mapper;

import com.fpt.vanguard.entity.NhanVien;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NhanVienMapper {
    List<NhanVien> findAll();
}
