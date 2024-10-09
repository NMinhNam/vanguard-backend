package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> findByUsername(@Param("userName") String username);
    List<User> findAll();
    Optional<User> findByRoleId(@Param("roleId") String roleId);
}
