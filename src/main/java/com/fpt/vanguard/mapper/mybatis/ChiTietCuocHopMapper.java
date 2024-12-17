package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.ChiTietCuocHop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChiTietCuocHopMapper {
    Integer insertChiTietCuocHop(ChiTietCuocHop chiTietCuocHop);
}
