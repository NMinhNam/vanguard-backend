package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.NhanVienViPham;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NhanVienViPhamMapper {
    List<NhanVienViPham> getAll();
    List<NhanVienViPham> getNhanVienViPhams(String maNhanVien);
    Integer insertNhanVienViPham(NhanVienViPham nhanVienViPham);
}
