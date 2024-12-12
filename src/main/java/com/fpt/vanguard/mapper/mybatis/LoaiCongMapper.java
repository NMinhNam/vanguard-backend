package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.LoaiCong;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoaiCongMapper {
    List<LoaiCong> getAllLoaiCongs();
    Integer insertLoaiCong(LoaiCong loaiCong);
    Integer updateLoaiCong(LoaiCong loaiCong);
    Integer deleteLoaiCong(String tenLoaiCong);
    Boolean isLoaiCongExist(String tenLoaiCong);
}
