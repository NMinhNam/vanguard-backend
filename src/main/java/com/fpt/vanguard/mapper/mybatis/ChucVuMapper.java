package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.ChucVuDtoRequest;
import com.fpt.vanguard.entity.ChucVu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChucVuMapper {
    List<ChucVu> findAll();

    ChucVu findById(String id);

    int insertChucVu(@Param("chucVu") ChucVu chucVu);

    int updateChucVu(@Param("chucVu") ChucVu chucVu);

    Boolean isExist(@Param("id") String id);

    int deleteChucVu(String id);

    String getTenChucVuByMaNhanVien(String maNhanVien);
}
