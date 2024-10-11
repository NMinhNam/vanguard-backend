package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.InvalidatedToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvalidatedTokenMapper {
    void insertInvalidatedToken(@Param("invalidToken") InvalidatedToken invalidatedToken);
    boolean isInvalidatedTokenExists(@Param("jwtId") String jwtId);
}
