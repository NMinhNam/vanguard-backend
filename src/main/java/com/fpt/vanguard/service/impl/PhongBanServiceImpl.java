package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.PhongBanDtoRequest;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.PhongBanMapstruct;
import com.fpt.vanguard.mapper.mybatis.PhongBanMapper;
import com.fpt.vanguard.service.PhongBanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PhongBanServiceImpl implements PhongBanService {
    private final PhongBanMapstruct phongBanMapstruct;
    private final PhongBanMapper phongBanMapper;

    @Override
    public List<PhongBanDtoResponse> getAllPhongBan() {
        var listEntity = phongBanMapper.findAll();
        List<PhongBanDtoResponse> listResultEntity =
                phongBanMapstruct.toPhongBanDtoResponseList(listEntity);
        if(listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_PHONG_BAN_EMPTY);
        return listResultEntity;
    }

    @Override
    public PhongBanDtoResponse findPhongBanByMaPhongBan(String maPhongBan) {
        PhongBanDtoResponse resultEntity = phongBanMapstruct.toPhongBanDtoResponse(
                phongBanMapper.findById(maPhongBan)
        );
        if(!Objects.nonNull(resultEntity)) throw new AppException(ErrorCode.PHONG_BAN_NOT_EXIST);
        return resultEntity;
    }

    @Override
    public int savePhongBan(PhongBanDtoRequest phongBan) {
        if(phongBanMapper.isExist(phongBan.getMaPhongBan())){
            return phongBanMapper.updatePhongBan(phongBan);
        }else {
            return phongBanMapper.insertPhongBan(phongBan);
        }
    }

    @Override
    public int deletePhongBan(String maPhongBan) {
        if (!phongBanMapper.isExist(maPhongBan))
            throw new AppException(ErrorCode.PHONG_BAN_NOT_EXIST);
        return phongBanMapper.deletePhongBan(maPhongBan);
    }
}
