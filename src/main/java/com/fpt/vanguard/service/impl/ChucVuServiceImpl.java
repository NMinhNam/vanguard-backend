package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.ChucVuDtoRequest;
import com.fpt.vanguard.dto.response.ChucVuDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.ChucVuMapstruct;
import com.fpt.vanguard.mapper.mybatis.ChucVuMapper;
import com.fpt.vanguard.service.ChucVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public ChucVuDtoResponse findChucVuByMaChucVu(String maChucVu) {
        ChucVuDtoResponse resultEntity = chucVuMapstruct.toChucVuDtoResponse(
                chucVuMapper.findById(maChucVu)
        );
        if (!Objects.nonNull(resultEntity)) throw new AppException(ErrorCode.PHONG_BAN_NOT_EXIST);
        return resultEntity;
    }

    @Override
    public int saveChucVu(ChucVuDtoRequest chucVu) {
        if (chucVuMapper.isExist(chucVu.getMaChucVu())) {
            return chucVuMapper.updateChucVu(chucVu);
        } else {
            return chucVuMapper.insertChucVu(chucVu);
        }
    }

    @Override
    public int deleteChucVu(String id) {
        if (!chucVuMapper.isExist(id)) throw new AppException(ErrorCode.CHUC_VU_NOT_EXIST);
        return chucVuMapper.deleteChucVu(id);
    }
}
