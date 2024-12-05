package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.WifiInfoDtoRequest;
import com.fpt.vanguard.dto.response.WifiInfoDtoResponse;

import java.util.List;

public interface WifiAuthService {
    Boolean isWifiValid(String publicIp);

    List<WifiInfoDtoResponse> getWifiList();

    Integer saveWifiInfo(WifiInfoDtoRequest request);
}
