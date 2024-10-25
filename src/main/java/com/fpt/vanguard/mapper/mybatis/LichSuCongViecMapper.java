package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.LichSuCongViec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LichSuCongViecMapper {
    List<LichSuCongViec> findByMaNhanVien(@Param("maNhanVien") String maNhanVien);
}
