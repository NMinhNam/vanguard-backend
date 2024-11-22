package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.HopDongDtoRequest;
import com.fpt.vanguard.dto.response.HopDongDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.HopDongMapstruct;
import com.fpt.vanguard.mapper.mybatis.HopDongMapper;
import com.fpt.vanguard.service.HopDongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HopDongServiceImpl implements HopDongService {
    private final HopDongMapper hopDongMapper;
    private final HopDongMapstruct hopDongMapstruct;

    @Override
    public List<HopDongDtoResponse> getAllHopDong() {
        List<HopDongDtoResponse> listResultEntity =
                hopDongMapstruct.toHopDongDtoResponseList(
                        hopDongMapper.getAllHopDong()
                );
        if (listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_HOP_DONG_EMPTY);
        return listResultEntity;
    }

    @Override
    public int saveHopDong(HopDongDtoRequest hopdong) {
        if (hopDongMapper.existsById(hopdong.getSoHopDong())) {
            return hopDongMapper.updateHopDong(hopdong);
        } else {
            return hopDongMapper.insertHopDong(hopdong);
        }
    }

    @Override
    public HopDongDtoResponse getHopDongById(String id) {
        return hopDongMapstruct.toHopDongDtoResponse(
                Optional.ofNullable(hopDongMapper.findById(id))
                        .orElseThrow(() -> new AppException(ErrorCode.HOP_DONG_NOT_EXIST))
        );
    }

    @Override
    public int deleteHopDong(String id) {
        if (!hopDongMapper.existsById(id)) throw new AppException(ErrorCode.HOP_DONG_NOT_EXIST);
        return hopDongMapper.deleteHopDong(id);
    }
}
