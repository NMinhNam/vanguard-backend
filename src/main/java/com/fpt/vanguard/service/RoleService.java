package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.response.RoleDtoResponse;

import java.util.List;

public interface RoleService {
    List<RoleDtoResponse> findAllRoles();
}
