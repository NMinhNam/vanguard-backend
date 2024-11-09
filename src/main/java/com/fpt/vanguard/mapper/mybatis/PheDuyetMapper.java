package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.dto.response.ApprovalDetailsDtoResponse;
import com.fpt.vanguard.entity.PheDuyet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PheDuyetMapper {
    List<PheDuyet> findAll(@Param("maNhanVien") String maNhanVien);
    Integer insertPheDuyet(@Param("pheDuyet") PheDuyet pheDuyet);
    Integer updatePheDuyet(@Param("pheDuyet") PheDuyet pheDuyet);
    Integer deletePheDuyet(@Param("maDon") String maDon);
    ApprovalDetailsDtoResponse getApprovalDetails(@Param("maNhanVien") String maNhanVien);
    ApprovalDetailsDtoResponse getInfoFromRequestApproval(@Param("maNhanVien") String maNhanVien);
    PheDuyet getPheDuyet(@Param("pheDuyet") PheDuyet pheDuyet);
    PheDuyet getApprovalStatusCount(@Param("maDon") String maDon);
}
