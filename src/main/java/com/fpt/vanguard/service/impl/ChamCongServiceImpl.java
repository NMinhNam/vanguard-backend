package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.ChamCongDtoRequest;
import com.fpt.vanguard.dto.response.ChamCongDtoResponse;
import com.fpt.vanguard.entity.BangChamCong;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.ChamCongMapstruct;
import com.fpt.vanguard.mapper.mybatis.ChamCongMapper;
import com.fpt.vanguard.mapper.mybatis.NhanVienMapper;
import com.fpt.vanguard.service.ChamCongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChamCongServiceImpl implements ChamCongService {
    private final ChamCongMapper chamCongMapper;
    private final ChamCongMapstruct chamCongMapstruct;
    private final NhanVienMapper nhanVienMapper;

    @Override
    public Integer doCheckIn(ChamCongDtoRequest request) {
        BangChamCong chamCongDtoRequest = chamCongMapstruct.toChamCong(request);

        Boolean isChamCong = chamCongMapper.isChamCong(chamCongDtoRequest);
        if (isChamCong) throw new AppException(ErrorCode.ATTENDED);

        return chamCongMapper.insertBangChamCong(chamCongDtoRequest);
    }

    @Override
    public Integer doCheckOut(ChamCongDtoRequest request) {
        BangChamCong chamCongDtoRequest = chamCongMapstruct.toChamCong(request);

        Boolean isChamCong = chamCongMapper.isChamCong(chamCongDtoRequest);
        if (!isChamCong) throw new AppException(ErrorCode.NOT_ATTENDED);

        Double soGioLam = tinhSoGioLam(request.getGioVao(), request.getGioRa());
        request.setSoGioLam(soGioLam);

        return chamCongMapper.updateBangChamCong(chamCongDtoRequest);
    }

    @Override
    public List<ChamCongDtoResponse> getChamCongNhanVien(String maNhanVien) {
        if (!nhanVienMapper.existsById(maNhanVien))
            throw new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST);

        return chamCongMapstruct.toDtoResponseList(
                chamCongMapper.findByMaNhanVien(maNhanVien)
        );
    }

    @Override
    public List<ChamCongDtoResponse> getAllChamCong() {
        return chamCongMapstruct.toDtoResponseList(
                chamCongMapper.findAll()
        );
    }

    private Double tinhSoGioLam(String gioVaoStr, String gioRaStr) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime gioVao = LocalTime.parse(gioVaoStr, timeFormatter);
        LocalTime gioRa = LocalTime.parse(gioRaStr, timeFormatter);

        long secondsWorked;
        if (gioRa.isAfter(gioVao) || gioRa.equals(gioVao)) {
            secondsWorked = Duration
                    .between(gioVao, gioRa)
                    .getSeconds();
        } else {
            secondsWorked = Duration
                    .between(gioVao, gioRa.plusHours(24))
                    .getSeconds();
        }

        return Math.round((secondsWorked / 3600.0) * 100.0) / 100.0;
    }
}