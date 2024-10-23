package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.DonYeuCauDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.DonYeuCauMapstruct;
import com.fpt.vanguard.mapper.mybatis.DonYeuCauMapper;
import com.fpt.vanguard.service.DonYeuCauService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonYeuCauServiceImpl implements DonYeuCauService {
    private final DonYeuCauMapper donYeuCauMapper;
    private final DonYeuCauMapstruct donYeuCauMapstruct;

    @Override
    public List<DonYeuCauDtoResponse> getDonYeuCau(String maNhanVien) {
        return donYeuCauMapstruct.toListResponseDto(
                donYeuCauMapper.findByMaNhanVien(maNhanVien)
        );
    }
}
