package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.BangLuong;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BangLuongMapper {
    List<BangLuong> getAllBangLuong();
    BangLuong getBangLuongNhanVienByMonth(String maNhanVien, Integer thang, Integer nam);
    List<BangLuong> getMucLuongTheoSoLuongNhanVien();
    List<BangLuong> getTongLuongNhanVienTheoThang(String maNhanVien);
    List<BangLuong> getBangLuongNhanVien(String maNhanVien);
    Integer updateBangLuongNhanVien(BangLuong bangLuong);
    Integer insertBangLuongNhanVien(BangLuong bangLuong);
    Boolean isBangLuongExist(String maNhanVien, Integer thang, Integer nam);
    Boolean isTinhLuong(String maNhanVien, Integer thang, Integer nam);
}
