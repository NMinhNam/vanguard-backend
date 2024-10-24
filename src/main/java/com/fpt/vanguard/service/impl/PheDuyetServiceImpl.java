package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.PheDuyetDtoRequest;
import com.fpt.vanguard.dto.response.PheDuyetDtoResponse;
import com.fpt.vanguard.enums.TrangThaiPheDuyet;
import com.fpt.vanguard.mapper.mapstruct.PheDuyetMapstruct;
import com.fpt.vanguard.mapper.mybatis.PheDuyetMapper;
import com.fpt.vanguard.service.PheDuyetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PheDuyetServiceImpl implements PheDuyetService {
    private final PheDuyetMapper pheDuyetMapper;
    private final PheDuyetMapstruct pheDuyetMapstruct;

    @Override
    public List<PheDuyetDtoResponse> getPheDuyets(String maNhanvien) {
        return pheDuyetMapstruct.toDtoList(
                pheDuyetMapper.findAll(maNhanvien)
        );
    }

    @Override
    public Integer createPheDuyet(PheDuyetDtoRequest request) {
        Integer trangThaiMacDinh = TrangThaiPheDuyet.CHO_DUYET.getTrangThaiPheDuyet();
        request.setTrangThai(trangThaiMacDinh);

        return pheDuyetMapper.insertPheDuyet(
                pheDuyetMapstruct.toPheDuyet(request)
        );
    }

    @Override
    public Integer updatePheDuyet(PheDuyetDtoRequest request) {
        return pheDuyetMapper.updatePheDuyet(
                pheDuyetMapstruct.toPheDuyet(request)
        );
    }

    @Override
    public Integer deletePheDuyet(String maDon) {
        return pheDuyetMapper.deletePheDuyet(maDon);
    }
}
