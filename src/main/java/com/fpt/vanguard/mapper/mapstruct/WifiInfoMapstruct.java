package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.WifiInfoDtoRequest;
import com.fpt.vanguard.dto.response.WifiInfoDtoResponse;
import com.fpt.vanguard.entity.WifiInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WifiInfoMapstruct {
    List<WifiInfoDtoResponse> mapDtoToResponseDto(List<WifiInfo> wifiInfo);
    WifiInfo mapDtoToEntity(WifiInfoDtoRequest request);
}
