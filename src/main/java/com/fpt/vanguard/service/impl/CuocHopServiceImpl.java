package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.dto.response.CuocHopDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.CuocHopMapstruct;
import com.fpt.vanguard.mapper.mybatis.CuocHopMapper;
import com.fpt.vanguard.service.CuocHopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CuocHopServiceImpl implements CuocHopService {
    private final CuocHopMapper cuocHopMapper;
    private final CuocHopMapstruct cuocHopMapstruct;

    @Override
    public List<CuocHopDtoResponse> getAllCuocHops() {
        return cuocHopMapstruct.toDtoList(cuocHopMapper.getAllCuocHops());
    }

    @Override
    public Integer saveCuocHop(CuocHopDtoRequest cuocHopDtoRequest) {
        String maCuocHop = cuocHopDtoRequest.getMaCuocHop();
        Boolean isCuocHopExist = cuocHopMapper.isCuocHopExist(maCuocHop);

        if (isCuocHopExist) return cuocHopMapper.updateCuocHop(cuocHopMapstruct.toCuocHop(cuocHopDtoRequest));

        return cuocHopMapper.insertCuocHop(cuocHopMapstruct.toCuocHop(cuocHopDtoRequest));
    }

    @Override
    public Integer deleteCuocHop(String maCuocHop) {
        return cuocHopMapper.deleteCuocHop(maCuocHop);
    }

    @Override
    public CuocHopDtoResponse getCuocHop(String maCuocHop) {
        return cuocHopMapstruct.toDtoResponse(Optional.ofNullable(cuocHopMapper.getCuocHop(maCuocHop)).orElseThrow(() -> new AppException(ErrorCode.CUOC_HOP_NOT_EXIST)));
    }
}
