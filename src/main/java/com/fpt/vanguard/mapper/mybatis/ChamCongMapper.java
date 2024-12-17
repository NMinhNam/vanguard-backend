package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.BangChamCong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChamCongMapper {
    List<BangChamCong> findByMaNhanVien(String maNhanVien);

    List<BangChamCong> findAll();

    Integer insertBangChamCong(@Param("bangChamCong") BangChamCong bangChamCong);

    Integer updateBangChamCong(@Param("bangChamCong") BangChamCong bangChamCong);

    Integer deleteBangChamCong(BangChamCong bangChamCong);

    Boolean isChamCong(BangChamCong bangChamCong);

    BangChamCong findDetail(String maNhanVien, String ngayChamCong);

    List<BangChamCong> findByMonth(String maNhanVien, Integer month, Integer year);

    Double getSoNgayCong(String maNhanVien, Integer month, Integer year);
}
