package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.RoleDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.RoleMapstruct;
import com.fpt.vanguard.mapper.mybatis.RoleMapper;
import com.fpt.vanguard.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleMapper roleMapper;
    private final RoleMapstruct roleMapstruct;

    @Override
    public List<RoleDtoResponse> findAllRoles() {
        return roleMapstruct.toRoleDtoResponse(roleMapper.getAll());
    }
}
