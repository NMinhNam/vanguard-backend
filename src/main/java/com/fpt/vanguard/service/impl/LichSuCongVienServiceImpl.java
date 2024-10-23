package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.LichSuCongViecDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.LichSuCongViecMapstruct;
import com.fpt.vanguard.mapper.mybatis.LichSuCongViecMapper;
import com.fpt.vanguard.service.LichSuCongViecService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LichSuCongVienServiceImpl implements LichSuCongViecService {
    private final LichSuCongViecMapper lichSuCongViecMapper;
    private final LichSuCongViecMapstruct lichSuCongViecMapstruct;

    @Override
    public List<LichSuCongViecDtoResponse> getLichSuCongViecByMaNhanVien(String maNhanVien) {
        return lichSuCongViecMapstruct.toDtoResponseList(
                lichSuCongViecMapper.findByMaNhanVien(maNhanVien)
        );
    }
}
