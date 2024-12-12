package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.PhuCap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NhanVienPhuCapMapper {
    Integer insertNhanVienPhuCap(PhuCap nhanVienPhuCap);
    Integer deleteNhanVienPhuCap(PhuCap phuCap);
}
