package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.ChucVuDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.ChucVuMapstruct;
import com.fpt.vanguard.mapper.mybatis.ChucVuMapper;
import com.fpt.vanguard.service.ChucVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChucVuServiceImpl implements ChucVuService {
    private final ChucVuMapper chucVuMapper;
    private final ChucVuMapstruct chucVuMapstruct;

    @Override
    public List<ChucVuDtoResponse> getAllChucVu() {
        return chucVuMapstruct.toDtoResponseList(
                chucVuMapper.findAll()
        );
    }
}
