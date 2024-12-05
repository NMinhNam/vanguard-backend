package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.ChamCongDtoRequest;
import com.fpt.vanguard.dto.response.ChamCongDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.ChamCongMapstruct;
import com.fpt.vanguard.mapper.mybatis.ChamCongMapper;
import com.fpt.vanguard.mapper.mybatis.NhanVienMapper;
import com.fpt.vanguard.service.ChamCongService;
import com.fpt.vanguard.service.LoaiCongService;
import com.fpt.vanguard.service.WifiAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChamCongServiceImpl implements ChamCongService {
    private final ChamCongMapper chamCongMapper;
    private final ChamCongMapstruct chamCongMapstruct;
    private final NhanVienMapper nhanVienMapper;
    private final LoaiCongService loaiCongService;
    private final WifiAuthService wifiAuthService;

    @Override
    public Integer doCheckIn(ChamCongDtoRequest request) {
        String publicIp = request.getPublicIp();
        wifiAuthService.isWifiValid(publicIp);

        String ngayChamCong = LocalDate.now().toString();
        request.setNgayChamCong(ngayChamCong);

        String gioVao = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        request.setGioVao(gioVao);

        Integer maLoaiCong = loaiCongService.getLoaiCong(ngayChamCong);
        request.setMaLoaiCong(maLoaiCong);

        return chamCongMapper.insertBangChamCong(
                chamCongMapstruct.toChamCong(request)
        );
    }

    @Override
    public Integer doCheckOut(ChamCongDtoRequest request) {
        String publicIp = request.getPublicIp();
        wifiAuthService.isWifiValid(publicIp);

        String ngayChamCong = LocalDate.now().toString();
        request.setNgayChamCong(ngayChamCong);

        String gioRa = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        request.setGioRa(gioRa);

        String gioVao = getChamCongDetail(request).getGioVao();

        Double soGioLam = tinhSoGioLam(gioVao, gioRa);
        request.setSoGioLam(soGioLam);

        return chamCongMapper.updateBangChamCong(
                chamCongMapstruct.toChamCong(request)
        );
    }

    @Override
    public List<ChamCongDtoResponse> getChamCongNhanVien(String maNhanVien) {
        if (!nhanVienMapper.existsById(maNhanVien)) throw new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST);

        return chamCongMapstruct.toDtoResponseList(chamCongMapper.findByMaNhanVien(maNhanVien));
    }

    @Override
    public List<ChamCongDtoResponse> getAllChamCong() {
        return chamCongMapstruct.toDtoResponseList(chamCongMapper.findAll());
    }

    @Override
    public ChamCongDtoResponse getChamCongDetail(ChamCongDtoRequest request) {
        return chamCongMapstruct.toDtoResponse(
                chamCongMapper.findDetail(request.getMaNhanVien(), request.getNgayChamCong())
        );
    }

    @Override
    public ChamCongDtoResponse getChamCongToDay(String maNhanVien) {
        String ngayHienTai = LocalDate.now().toString();

        return chamCongMapstruct.toDtoResponse(
                chamCongMapper.findDetail(maNhanVien, ngayHienTai)
        );
    }

    private Double tinhSoGioLam(String gioVaoStr, String gioRaStr) {
        LocalTime gioVao = LocalTime.parse(gioVaoStr, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime gioRa = LocalTime.parse(gioRaStr, DateTimeFormatter.ofPattern("HH:mm"));

        long giayLamViec;
        if (gioRa.isAfter(gioVao) || gioRa.equals(gioVao)) {
            giayLamViec = Duration.between(gioVao, gioRa).getSeconds();
        } else {
            giayLamViec = Duration.between(gioVao, gioRa.plusHours(24)).getSeconds();
        }

        return Math.round((giayLamViec / 3600.0) * 100.0) / 100.0;
    }
}
