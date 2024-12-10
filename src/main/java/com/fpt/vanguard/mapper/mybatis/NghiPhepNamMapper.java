package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.NghiPhepNam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NghiPhepNamMapper {
    NghiPhepNam getNghiPhepNam();
    Integer insertNghiPhepNam(NghiPhepNam nghiPhepNam);
    Integer updateTongSoNgayPhepCongDon();
    Integer updateTongSoNgayPhepNam();
}
