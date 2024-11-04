package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.BangChamCong;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChamCongMapper {
    List<BangChamCong> findByMaNhanVien();

    List<BangChamCong> findAll();

    Integer insertBangChamCong(BangChamCong bangChamCong);

    Integer updateBangChamCong(BangChamCong bangCong);

    Integer deleteBangChamCong(BangChamCong bangCong);
}
