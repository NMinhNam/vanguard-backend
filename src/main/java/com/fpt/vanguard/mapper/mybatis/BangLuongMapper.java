package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.BangLuong;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BangLuongMapper {
    List<BangLuong> getAllBangLuong();
    BangLuong getBangLuongNhanVienByMonth();
    List<BangLuong> getMucLuongTheoSoLuongNhanVien();
    List<BangLuong> getTongLuongNhanVienTheoThang(String maNhanVien);
}
