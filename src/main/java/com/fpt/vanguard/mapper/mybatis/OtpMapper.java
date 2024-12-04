package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.Otp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OtpMapper {
    Integer insertOtp(Otp otp);
    Otp findLatestOtpByEmail(@Param("email") String email);
    Integer deleteOtp(@Param("email") String email);
}
