package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.UngLuongDtoRequest;
import com.fpt.vanguard.entity.UngLuong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UngLuongMapper {
    List<UngLuong> findAll();

    UngLuong findById(String id);

    UngLuong findUngLuong(@Param("ungLuong") UngLuongDtoRequest ungLuongDtoRequest);

    int insertUngLuong(@Param("ungLuong") UngLuongDtoRequest ungLuongDtoRequest);

    int updateUngLuong(@Param("ungLuong") UngLuongDtoRequest ungLuongDtoRequest);

    int deleteUngLuong(String id);

    Boolean existsById(String id);
}
