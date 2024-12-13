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
        return viPhamMapstruct.toResponseList(viPhamMapper.getAllViPham());
    }

    @Override
    public Integer saveViPham(ViPhamDtoRequest viPhamDtoRequest) {
        String maViPham = viPhamDtoRequest.getMaViPham();
        Boolean isViPhamExist = viPhamMapper.isViPhamExist(maViPham);

        if (isViPhamExist) return viPhamMapper.updateViPham(viPhamMapstruct.toViPham(viPhamDtoRequest));
        return viPhamMapper.insertViPham(viPhamMapstruct.toViPham(viPhamDtoRequest));
    }

    @Override
    public Integer deleteViPham(String maViPham) {
        return viPhamMapper.deleteViPham(maViPham);
    }
}
