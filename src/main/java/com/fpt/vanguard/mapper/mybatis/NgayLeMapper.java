package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.NgayLe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface NgayLeMapper {
    List<NgayLe> getAllNgayLes();
    Integer insertNgayLe(NgayLe ngayLe);
    Integer updateNgayLe(NgayLe ngayLe);
    Integer deleteNgayLe(String tenNgayLe);
    Boolean isNgayLeExist(String tenNgayLe);
    Boolean isNgayLe(@Param("ngayChamCong") String ngayChamCong);
}
