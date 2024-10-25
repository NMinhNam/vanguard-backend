package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.ChucVu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChucVuMapper {
    List<ChucVu> findAll();
}
