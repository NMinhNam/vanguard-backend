package com.fpt.vanguard.mapper.mybatis;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PasswordMapper {
    Integer changePassword(String newPassword, String email);
    Integer forgotPassword(String email);
    Boolean isMailExist(String email);
    Boolean checkPassword(String email, String currPwd);
}
