package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.NgayLe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

@Mapper
public interface NgayLeMapper {
    Boolean isNgayLe(@Param("ngayChamCong") String ngayChamCong);
}
