package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> getAll();
}
