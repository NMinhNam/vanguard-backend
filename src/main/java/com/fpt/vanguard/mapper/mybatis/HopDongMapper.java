package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.HopDongDtoRequest;
import com.fpt.vanguard.entity.HopDong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface HopDongMapper {
    List<HopDong> getAllHopDong();

    int insertHopDong(@Param("hopDong") HopDongDtoRequest hopDongDtoRequest);

    int updateHopDong(@Param("hopDong") HopDongDtoRequest hopDongDtoRequest);

    Boolean existsById(String id);

    HopDong findById(String id);

    int deleteHopDong(String id);

    List<HopDong> getListHopDongByMaNhanVien(@Param("maNhanVien") String maNhanVien);

    HopDong getHopDongByMaNhanVien(@Param("maNhanVien") String maNhanVien);
}
