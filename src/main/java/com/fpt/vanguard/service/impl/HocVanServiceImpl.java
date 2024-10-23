package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.HocVanDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.HocVanMapstruct;
import com.fpt.vanguard.mapper.mybatis.HocVanMapper;
import com.fpt.vanguard.service.HocVanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HocVanServiceImpl implements HocVanService {
    private final HocVanMapper hocVanMapper;
    private final HocVanMapstruct hocVanMapstruct;

    @Override
    public List<HocVanDtoResponse> getAllHocVan() {
        return hocVanMapstruct.toHocVanDtoResponseList(
                hocVanMapper.findAll()
        );
    }
}
