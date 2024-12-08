package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.DonYeuCauDtoRequest;
import com.fpt.vanguard.dto.response.DonYeuCauDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.enums.TrangThaiPheDuyet;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.DonYeuCauMapstruct;
import com.fpt.vanguard.mapper.mybatis.DonYeuCauMapper;
import com.fpt.vanguard.service.DonYeuCauService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonYeuCauServiceImpl implements DonYeuCauService {
    private final DonYeuCauMapper donYeuCauMapper;
    private final DonYeuCauMapstruct donYeuCauMapstruct;

    @Override
    public List<DonYeuCauDtoResponse> getDonYeuCauByMaNhanVien(String maNhanVien) {
        return donYeuCauMapstruct.toListResponseDto(
                donYeuCauMapper.findByMaNhanVien(maNhanVien)
        );
    }

    @Override
    public Integer createDonYeuCau(DonYeuCauDtoRequest request) {
        String maDon = request.getMaDon();
        Boolean isExistDonYeuCau = donYeuCauMapper.isExistDonYeuCau(maDon);
        if (isExistDonYeuCau) throw new AppException(ErrorCode.DON_YEU_CAU_EXISTED);

        Integer trangThaiMacDinh = TrangThaiPheDuyet.TAO_MOI.getTrangThaiPheDuyet();
        request.setTrangThai(trangThaiMacDinh);

        String ngayTao = LocalDate.now().toString();
        request.setNgayTao(ngayTao);

        return donYeuCauMapper.insertDonYeuCau(
                donYeuCauMapstruct.toDonYeuCau(request)
        );
    }

    @Override
    public Integer deleteDonYeuCau(String maDon) {
        Boolean isExistDonYeuCau = donYeuCauMapper.isExistDonYeuCau(maDon);
        if (!isExistDonYeuCau) throw new AppException(ErrorCode.DON_YEU_CAU_NOT_EXIST);

        return donYeuCauMapper.deleteDonYeuCau(maDon);
    }

    @Override
    public List<DonYeuCauDtoResponse> getAllDonYeuCau() {
        return donYeuCauMapstruct.toListResponseDto(
                donYeuCauMapper.findAll()
        );
    }

    @Override
    public Integer updateDonYeuCau(DonYeuCauDtoRequest request) {
        String maDon = request.getMaDon();
        Boolean isExistDonYeuCau = donYeuCauMapper.isExistDonYeuCau(maDon);
        if (!isExistDonYeuCau) throw new AppException(ErrorCode.DON_YEU_CAU_NOT_EXIST);

        return donYeuCauMapper.updateDonYeuCau(
                donYeuCauMapstruct.toDonYeuCau(request)
        );
    }
}
