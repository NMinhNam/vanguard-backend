package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.PhongBanDtoRequest;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;
import com.fpt.vanguard.entity.PhongBan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhongBanMapstruct {
    PhongBan toPhongBan(PhongBanDtoRequest phongBan);

    PhongBanDtoResponse toPhongBanDtoResponse(PhongBan phongBan);

    List<PhongBanDtoResponse> toPhongBanDtoResponseList(List<PhongBan> phongBans);
}
