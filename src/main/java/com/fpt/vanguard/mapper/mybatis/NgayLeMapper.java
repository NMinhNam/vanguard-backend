package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.NgayLe;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.Optional;

@Mapper
public interface NgayLeMapper {
    Optional<NgayLe> findByNgayLe(LocalDate localDate);
}
