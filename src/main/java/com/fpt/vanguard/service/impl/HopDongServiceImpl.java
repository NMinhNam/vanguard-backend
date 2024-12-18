package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.HopDongDtoRequest;
import com.fpt.vanguard.dto.request.NghiPhepNamDtoRequest;
import com.fpt.vanguard.dto.response.HopDongDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.HopDongMapstruct;
import com.fpt.vanguard.mapper.mybatis.HopDongMapper;
import com.fpt.vanguard.service.HopDongService;
import com.fpt.vanguard.service.NghiPhepNamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HopDongServiceImpl implements HopDongService {
    private final HopDongMapper hopDongMapper;
    private final HopDongMapstruct hopDongMapstruct;
    private final NghiPhepNamService nghiPhepNamService;

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
        String maNhanVien = hopdong.getMaNhanVien();
        LocalDate ngayBatDau = hopdong.getNgayBatDau();
        if (hopDongMapper.existsById(hopdong.getSoHopDong())) {
            return hopDongMapper.updateHopDong(hopdong);
        } else {
            NghiPhepNamDtoRequest request = NghiPhepNamDtoRequest.builder().maNhanVien(maNhanVien).build();
            int req = hopDongMapper.insertHopDong(hopdong);
            if (req > 0) {
                nghiPhepNamService.createNghiPhepNamChoNhanVienMoi(ngayBatDau, request);
            }
            return req;
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

    @Override
    public List<HopDongDtoResponse> getListHopDongByMaNhanVien(String maNhanVien) {
        List<HopDongDtoResponse> listResultEntity =
                hopDongMapstruct.toHopDongDtoResponseList(
                        hopDongMapper.getListHopDongByMaNhanVien(maNhanVien)
                );
        if (listResultEntity.isEmpty()) {
            throw new AppException(ErrorCode.HOP_DONG_NOT_EXIST);
        }
        return listResultEntity;
    }

    @Override
    public HopDongDtoResponse getHopDongByMaNhanVien(String maNhanVien) {
        return hopDongMapstruct.toHopDongDtoResponse(
                hopDongMapper.getHopDongByMaNhanVien(maNhanVien)
        );
    }
}
