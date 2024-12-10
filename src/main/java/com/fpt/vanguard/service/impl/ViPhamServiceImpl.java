package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.ViPhamDtoRequest;
import com.fpt.vanguard.dto.response.ViPhamDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.ViPhamMapstruct;
import com.fpt.vanguard.mapper.mybatis.ViPhamMapper;
import com.fpt.vanguard.service.ViPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViPhamServiceImpl implements ViPhamService {
    private final ViPhamMapper viPhamMapper;
    private final ViPhamMapstruct viPhamMapstruct;

    @Override
    public List<ViPhamDtoResponse> getAllViPhams() {
        return viPhamMapstruct.toResponseList(
                viPhamMapper.getAllViPham()
        );
    }

    @Override
    public Integer saveViPham(ViPhamDtoRequest viPhamDtoRequest) {
        return 0;
    }

    @Override
    public Integer deleteViPham(String maViPham) {
        return 0;
    }
}
