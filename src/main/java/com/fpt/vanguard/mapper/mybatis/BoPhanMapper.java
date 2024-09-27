package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.request.BoPhanDtoRequest;
import com.fpt.vanguard.entity.BoPhan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoPhanMapper {
    List<BoPhan> getAllBoPhan();

    BoPhan findById(String id);

    int insertBoPhan(@Param("BoPhan") BoPhanDtoRequest boPhan);

    int updateBoPhan(@Param("BoPhan") BoPhanDtoRequest boPhan);

    int deleteBoPhan(@Param("id") String id);

    Boolean isExist(@Param("id") String id);
}
