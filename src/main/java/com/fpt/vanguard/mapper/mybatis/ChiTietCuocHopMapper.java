package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.ChiTietCuocHop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChiTietCuocHopMapper {
    Integer insertChiTietCuocHop(ChiTietCuocHop chiTietCuocHop);
    List<String> getDanhSachMaNhanVienByCuocHop(String maCuocHop);
    Integer deleteChiTietCuocHop(String maCuocHop, String maNhanVien);
}
