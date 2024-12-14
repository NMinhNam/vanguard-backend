package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.CuocHop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CuocHopMapper {
    Integer insertCuocHop(CuocHop cuochop);
    Integer updateCuocHop(CuocHop cuochop);
    Integer deleteCuocHop(String maCuocHop);
    List<CuocHop> getAllCuocHops();
    Boolean isCuocHopExist(String maCuocHop);
    CuocHop getCuocHop(String maCuocHop);
    CuocHop getMaCuocHop(CuocHop cuocHop);
    List<CuocHop> getCuocHopByMaNhanVien(String maNhanVien);
    List<CuocHop> getInfoNhanVienFromCuocHop(String maCuocHop);
}
