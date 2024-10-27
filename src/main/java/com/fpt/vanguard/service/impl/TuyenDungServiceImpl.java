package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.ViTriTuyenDungDtoRequest;
import com.fpt.vanguard.dto.response.ViTriTuyenDungDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.ViTriTuyenDungMapstruct;
import com.fpt.vanguard.mapper.mybatis.TuyenDungMapper;
import com.fpt.vanguard.service.TuyenDungService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TuyenDungServiceImpl implements TuyenDungService {
    private final ViTriTuyenDungMapstruct viTriTuyenDungMapstructMapper;
    private final TuyenDungMapper tuyenDungMapper;

    @Override
    public List<ViTriTuyenDungDtoResponse> getAllTuyenDung() {
        List<ViTriTuyenDungDtoResponse> listResultEntity =
                viTriTuyenDungMapstructMapper.toDtoResponseList(
                        tuyenDungMapper.getAllTuyenDung()
                );
        if (listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_PHONG_BAN_EMPTY);
        return listResultEntity;
    }

    @Override
    public ViTriTuyenDungDtoResponse getTuyenDungById(String maViTriTuyenDung) {
        ViTriTuyenDungDtoResponse resultEntity = viTriTuyenDungMapstructMapper.toTuyenDungDtoResponse(
                tuyenDungMapper.getTuyenDungById(maViTriTuyenDung)
        );
        if (!Objects.nonNull(resultEntity))
            throw new AppException(ErrorCode.PHONG_BAN_NOT_EXIST);
        return resultEntity;
    }

    @Override
    public int saveTuyenDung(ViTriTuyenDungDtoRequest tuyenDung) {
        if (tuyenDungMapper.isExist(tuyenDung.getMaViTriTuyenDung())) {
            return tuyenDungMapper.updateTuyenDung(
                    viTriTuyenDungMapstructMapper.toTuyenDung(tuyenDung)
            );
        }

        return tuyenDungMapper.insertTuyenDung(
                viTriTuyenDungMapstructMapper.toTuyenDung(tuyenDung)
        );
    }
}
