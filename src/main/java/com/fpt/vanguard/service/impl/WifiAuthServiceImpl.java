package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.WifiInfoDtoRequest;
import com.fpt.vanguard.dto.response.WifiInfoDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.WifiInfoMapstruct;
import com.fpt.vanguard.mapper.mybatis.WifiMapper;
import com.fpt.vanguard.service.WifiAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WifiAuthServiceImpl implements WifiAuthService {
    private final WifiMapper wifiMapper;
    private final WifiInfoMapstruct mapstruct;

    @Override
    public Boolean isWifiValid(String publicIp) {
        Boolean isAuthWifi = wifiMapper.isWifiInfoExist(publicIp);
        if (!isAuthWifi) throw new AppException(ErrorCode.WIFI_NOT_VALID);
        return true;
    }

    @Override
    public List<WifiInfoDtoResponse> getWifiList() {
        return mapstruct.mapDtoToResponseDto(
                wifiMapper.getWifiInfoList()
        );
    }

    @Override
    public Integer saveWifiInfo(WifiInfoDtoRequest request) {
        return wifiMapper.insertWifiInfo(
                mapstruct.mapDtoToEntity(request)
        );
    }
}
