package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.DonYeuCauDtoRequest;
import com.fpt.vanguard.dto.response.DonYeuCauDtoResponse;
import com.fpt.vanguard.entity.DonYeuCau;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DonYeuCauMapstruct {
    List<DonYeuCauDtoResponse> toListResponseDto(List<DonYeuCau> donYeuCauList);
    DonYeuCau toDonYeuCau(DonYeuCauDtoRequest request);
}
