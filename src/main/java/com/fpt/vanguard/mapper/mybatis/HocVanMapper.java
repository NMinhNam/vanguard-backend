package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.HocVan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HocVanMapper {
    List<HocVan> findAll();
    List<HocVan> findByMaNhanVien(@Param("maNhanVien") String maNhanVien);
    Integer insertHocVan(HocVan hocVan);
    Integer updateHocVan(HocVan hocVan);
}
