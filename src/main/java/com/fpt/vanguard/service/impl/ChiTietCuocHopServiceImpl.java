package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.mapper.mapstruct.ChiTietCuocHopMapstruct;
import com.fpt.vanguard.mapper.mybatis.ChiTietCuocHopMapper;
import com.fpt.vanguard.service.ChiTietCuocHopService;
import com.fpt.vanguard.service.CuocHopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChiTietCuocHopServiceImpl implements ChiTietCuocHopService {
    private final ChiTietCuocHopMapper cuocHopMapper;
    private final ChiTietCuocHopMapstruct cuocHopMapstruct;
    private final CuocHopService cuocHopService;

    @Override
    public Integer addNhanVienToCuocHop(CuocHopDtoRequest request) {
        String maCuocHop = cuocHopService.getMaCuocHop(request);
        request.setMaCuocHop(maCuocHop);
        return cuocHopMapper.insertChiTietCuocHop(cuocHopMapstruct.toChiTietCuocHop(request));
    }
}
