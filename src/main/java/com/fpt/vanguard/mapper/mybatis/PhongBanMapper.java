package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.PhongBanDtoRequest;
import com.fpt.vanguard.entity.NhanVien;
import com.fpt.vanguard.entity.PhongBan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhongBanMapper {
    List<PhongBan> findAll();

    PhongBan findById(String id);

    int insertPhongBan(@Param("PhongBan") PhongBanDtoRequest phongBan);

    int updatePhongBan(@Param("PhongBan") PhongBanDtoRequest phongBan);

    int deletePhongBan(@Param("id") String id);

    Boolean isExist(@Param("id") String id);

    List<PhongBan> orgChartPhongBan();

    List<PhongBan> getSoLuongNhanVienTheoPhongBan();

    List<PhongBan> getTongLuongTheoPhongBan();

    List<PhongBan> getBienDongNhanVienTheoPhongBan();

    Integer getTongSoPhongBan();
}
