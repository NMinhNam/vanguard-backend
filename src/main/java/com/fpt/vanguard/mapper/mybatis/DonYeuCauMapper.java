package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.DonYeuCau;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DonYeuCauMapper {
    List<DonYeuCau> findByMaNhanVien(@Param("maNhanVien") String maNhanVien);
    Integer insertDonYeuCau(@Param("donYeuCau") DonYeuCau donYeuCau);
    Integer deleteDonYeuCau(@Param("maDon") String maDon);
    Boolean isExistDonYeuCau(@Param("maDon") String maDon);
    List<DonYeuCau> findAll();
}
