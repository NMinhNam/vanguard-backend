package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WifiInfoDtoRequest {
    private String wifiName;
    private String publicIp;
}
