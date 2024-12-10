package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.ViTriTuyenDung;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TuyenDungMapper {
    List<ViTriTuyenDung> getAllTuyenDung();

    ViTriTuyenDung getTuyenDungById(String id);

    int insertTuyenDung(@Param("tuyenDung") ViTriTuyenDung tuyenDung);

    int updateTuyenDung(@Param("TuyenDung") ViTriTuyenDung tuyenDung);

    Boolean isExist(@Param("id") String maTuyenDung);

    String getMaViTriByTenViTri(@Param("tenViTri") String tenViTri);
}
