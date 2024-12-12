package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.NghiPhepNam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NghiPhepNamMapper {
    NghiPhepNam getNghiPhepNam(@Param("maNhanVien") String maNhanVien,
                               @Param("nam") Integer nam);

    Integer insertNghiPhepNam(@Param("nghiPhepNam") NghiPhepNam nghiPhepNam);

    Integer updateTongSoNgayPhepCon(@Param("nghiPhepNam") NghiPhepNam nghiPhepNam);

    Integer updateTongSoNgayPhepNam(@Param("maNhanVien") String maNhanVien,
                                    @Param("nam") Integer nam,
                                    @Param("soNgayNghi") Integer soNgayNghi);

    Boolean isExistNghiPhepNam(@Param("maNhanVien") String maNhanVien,
                               @Param("nam") Integer nam);
}
