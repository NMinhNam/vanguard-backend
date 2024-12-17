package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.PhuCapDtoRequest;
import com.fpt.vanguard.entity.PhuCap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhuCapMapper {
    List<PhuCap> getAllPhuCaps();
    Integer insertPhuCap(PhuCap phuCap);
    Integer updatePhuCap(PhuCap phuCap);
    Integer deletePhuCap(String maPhuCap);
    Boolean isPhuCapExist(String maPhuCap);
    PhuCap getNhanVienPhuCap(PhuCapDtoRequest phuCapDtoRequest);
    Double getSumNhanVienPhuCapByMonth(String maNhanVien, Integer thang, Integer nam);
}