package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.ViPham;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViPhamMapper {
    List<ViPham> getAllViPham();
    Integer insertViPham(ViPham viPham);
    Integer updateViPham(ViPham viPham);
    Integer deleteViPham(String maViPham);
    Boolean isViPhamExist(String maViPham);
    Double getSumNhanVienViPhamByMonth(String maNhanVien, Integer thang, Integer nam);
}
