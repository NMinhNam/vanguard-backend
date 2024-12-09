package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.HocVanDtoRequest;
import com.fpt.vanguard.dto.response.HocVanDtoResponse;
import com.fpt.vanguard.entity.HocVan;
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
        return hocVanMapstruct.toHocVanDtoResponseList(hocVanMapper.findAll());
    }

    @Override
    public List<HocVanDtoResponse> getHocVan(String maNhanVien) {
        return hocVanMapstruct.toHocVanDtoResponseList(hocVanMapper.findByMaNhanVien(maNhanVien));
    }

    @Override
    public Integer saveHocVan(HocVanDtoRequest request) {
        HocVan hocVan = hocVanMapstruct.toHocVan(request);

        if (hocVanMapper.isHocVanExist(hocVan)) hocVanMapper.updateHocVan(hocVan);
        return hocVanMapper.insertHocVan(hocVan);
    }

    @Override
    public Integer deleteHocVan(HocVanDtoRequest request) {
        return hocVanMapper.deleteHocVan(hocVanMapstruct.toHocVan(request));
    }
}
