package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.NghiPhepNamDtoResponse;
import com.fpt.vanguard.mapper.mybatis.NghiPhepNamMapper;
import com.fpt.vanguard.service.NghiPhepNamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NghiPhepNamServiceImpl implements NghiPhepNamService {
    private final NghiPhepNamMapper nghiPhepNamMapper;

    @Override
    public NghiPhepNamDtoResponse getNgayNghiPhepNam() {
        return null;
    }
}
