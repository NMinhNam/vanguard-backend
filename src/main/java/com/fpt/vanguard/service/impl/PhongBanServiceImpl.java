package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.PhongBanDtoRequest;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.mapper.mapstruct.PhongBanMapstructMapper;
import com.fpt.vanguard.mapper.mybatis.PhongBanMybatisMapper;
import com.fpt.vanguard.service.PhongBanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PhongBanServiceImpl implements PhongBanService {
    private final PhongBanMapstructMapper phongBanMapstructMapper;
    private final PhongBanMybatisMapper phongBanMybatisMapper;

    @Override
    public List<PhongBanDtoResponse> getAllPhongBan() {
        List<PhongBanDtoResponse> listResultEntity = phongBanMybatisMapper.getAllPhongBan()
                .stream()
                .map(phongBanMapstructMapper::toPhongBanDtoResponse)
                .toList();
        if(listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_PHONG_BAN_EMPTY);
        return listResultEntity;
    }

    @Override
    public PhongBanDtoResponse findPhongBanByMaPhongBan(String maPhongBan) {
        PhongBanDtoResponse resultEntity = phongBanMapstructMapper.toPhongBanDtoResponse(
                phongBanMybatisMapper.findById(maPhongBan)
        );
        if(!Objects.nonNull(resultEntity)) throw new AppException(ErrorCode.PHONG_BAN_NOT_EXIST);
        return resultEntity;
    }

    @Override
    public int savePhongBan(PhongBanDtoRequest phongBan) {
        if(phongBanMybatisMapper.isExist(phongBan.getMaPhongBan())){
            return phongBanMybatisMapper.updatePhongBan(phongBan);
        }else {
            return phongBanMybatisMapper.insertPhongBan(phongBan);
        }
    }

    @Override
    public int deletePhongBan(String maPhongBan) {
        if (!phongBanMybatisMapper.isExist(maPhongBan)) throw new AppException(ErrorCode.PHONG_BAN_NOT_EXIST);
        return phongBanMybatisMapper.deletePhongBan(maPhongBan);
    }
}
