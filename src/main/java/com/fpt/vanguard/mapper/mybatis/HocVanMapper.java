package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.HocVan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HocVanMapper {
    List<HocVan> findAll();
    Integer insertHocVan(HocVan hocVan);
    Integer updateHocVan(HocVan hocVan);
}
