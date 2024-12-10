package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.PhuCapDtoRequest;
import com.fpt.vanguard.dto.response.PhuCapDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.PhuCapMapstruct;
import com.fpt.vanguard.mapper.mybatis.PhuCapMapper;
import com.fpt.vanguard.service.PhuCapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhuCapServiceImpl implements PhuCapService {
    private final PhuCapMapper phuCapMapper;
    private final PhuCapMapstruct phuCapMapstruct;

    @Override
    public List<PhuCapDtoResponse> getAllPhuCaps() {
        return phuCapMapstruct.toListDtoResponses(
                phuCapMapper.getAllPhuCaps()
        );
    }

    @Override
    public Integer savePhuCap(PhuCapDtoRequest phuCapDtoRequest) {
        return 0;
    }

    @Override
    public Integer deletePhuCap(String maPhuCap) {
        return 0;
    }
}
