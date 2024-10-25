package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.TuyenDungDtoRequest;
import com.fpt.vanguard.entity.TuyenDung;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TuyenDungMapper {
    List<TuyenDung> getAllTuyenDung();
    TuyenDung getTuyenDungById(String id);
    int insertTuyenDung(@Param("TuyenDung") TuyenDungDtoRequest tuyenDung);

//    int updateTuyenDung(@Param("TuyenDung") TuyenDungDtoRequest tuyenDung);
    Boolean isExist(@Param("id") String maTuyenDung);
}
