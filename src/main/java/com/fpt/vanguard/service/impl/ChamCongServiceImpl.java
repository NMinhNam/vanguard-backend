package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.ChamCongDtoRequest;
import com.fpt.vanguard.dto.request.NhanVienViPhamDtoRequest;
import com.fpt.vanguard.dto.response.ChamCongDtoResponse;
import com.fpt.vanguard.dto.response.LoaiCongDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.enums.TinhLuong;
import com.fpt.vanguard.enums.ViPham;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.ChamCongMapstruct;
import com.fpt.vanguard.mapper.mybatis.ChamCongMapper;
import com.fpt.vanguard.mapper.mybatis.NhanVienMapper;
import com.fpt.vanguard.service.ChamCongService;
import com.fpt.vanguard.service.LoaiCongService;
import com.fpt.vanguard.service.NhanVienViPhamService;
import com.fpt.vanguard.service.WifiAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChamCongServiceImpl implements ChamCongService {
    private final ChamCongMapper chamCongMapper;
    private final ChamCongMapstruct chamCongMapstruct;
    private final NhanVienMapper nhanVienMapper;
    private final LoaiCongService loaiCongService;
    private final WifiAuthService wifiAuthService;
    private final NhanVienViPhamService viPhamService;

    @Override
    public Integer doCheckIn(ChamCongDtoRequest request) {
        String publicIp = request.getPublicIp();
        Boolean isWifiValid = wifiAuthService.isWifiValid(publicIp);
        if (!isWifiValid) throw new AppException(ErrorCode.WIFI_NOT_VALID);

        String ngayChamCong = LocalDate.now().toString();
        request.setNgayChamCong(ngayChamCong);

        Boolean isChamCong = chamCongMapper.isChamCong(chamCongMapstruct.toChamCong(request));
        if (isChamCong) throw new AppException(ErrorCode.CHAM_CONG_EXISTED);

        String gioVao = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        request.setGioVao(gioVao);

        Integer maLoaiCong = loaiCongService.getLoaiCong(ngayChamCong);
        request.setMaLoaiCong(maLoaiCong);

        ghiNhanViPham(gioVao, null, ngayChamCong, request.getMaNhanVien());

        return chamCongMapper.insertBangChamCong(chamCongMapstruct.toChamCong(request));
    }

    @Override
    public Integer doCheckOut(ChamCongDtoRequest request) {
        String publicIp = request.getPublicIp();
        Boolean isWifiValid = wifiAuthService.isWifiValid(publicIp);
        if (!isWifiValid) throw new AppException(ErrorCode.WIFI_NOT_VALID);

        String ngayChamCong = LocalDate.now().toString();
        request.setNgayChamCong(ngayChamCong);

        Boolean isChamCong = chamCongMapper.isChamCong(chamCongMapstruct.toChamCong(request));
        if (!isChamCong) throw new AppException(ErrorCode.CHAM_CONG_NOT_EXIST);

        String gioRa = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        request.setGioRa(gioRa);

        String gioVao = getChamCongDetail(request).getGioVao();

        Double soGioLam = tinhSoGioLam(gioVao, gioRa);
        request.setSoGioLam(soGioLam);

        ghiNhanViPham(null, gioRa, ngayChamCong, request.getMaNhanVien());

        return chamCongMapper.updateBangChamCong(chamCongMapstruct.toChamCong(request));
    }

    private void ghiNhanViPham(String gioVao, String gioRa, String ngay, String maNhanVien) throws DateTimeParseException {
        Integer maLoaiCong = loaiCongService.getLoaiCong(ngay);
        LoaiCongDtoResponse loaiCong = loaiCongService.getLoaiCongByNgay(maLoaiCong);

        LocalTime gioBatDauCa = LocalTime.parse(loaiCong.getGioBatDau());
        LocalTime gioKetThucCa = LocalTime.parse(loaiCong.getGioKetThuc());
        if (gioVao != null) {
            LocalTime gioVaoThucTe = LocalTime.parse(gioVao, DateTimeFormatter.ofPattern("HH:mm"));
            if (gioVaoThucTe.isAfter(gioBatDauCa)) {
                viPhamService.insertNhanVienViPham(NhanVienViPhamDtoRequest.builder().maViPham(ViPham.DI_TRE.getMaViPham()).maNhanVien(maNhanVien).build());
            }
        }

        if (gioRa != null) {
            LocalTime gioRaThucTe = LocalTime.parse(gioRa, DateTimeFormatter.ofPattern("HH:mm"));
            if (gioRaThucTe.isBefore(gioKetThucCa)) {
                viPhamService.insertNhanVienViPham(NhanVienViPhamDtoRequest.builder().maViPham(ViPham.VE_SOM.getMaViPham()).maNhanVien(maNhanVien).build());
            }
        }
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
        return chamCongMapstruct.toDtoResponse(chamCongMapper.findDetail(request.getMaNhanVien(), request.getNgayChamCong()));
    }

    @Override
    public ChamCongDtoResponse getChamCongToDay(String maNhanVien) {
        String ngayHienTai = LocalDate.now().toString();

        return chamCongMapstruct.toDtoResponse(chamCongMapper.findDetail(maNhanVien, ngayHienTai));
    }

    @Override
    public List<ChamCongDtoResponse> getChamCongByThang(ChamCongDtoRequest request) {
        String maNhanVien = request.getMaNhanVien();
        LocalDate ngayChamCong = LocalDate.parse(request.getNgayChamCong());
        Integer thang = ngayChamCong.getMonthValue();
        Integer nam = ngayChamCong.getYear();
        return chamCongMapstruct.toDtoResponseList(chamCongMapper.findByMonth(maNhanVien, thang, nam));
    }

    @Override
    public Double tinhSoNgayCong(String maNhanVien, Integer thang, Integer nam) {
        Double soNgayCong = chamCongMapper.getSoNgayCong(maNhanVien, thang, nam);
        if (soNgayCong != null) {
            return soNgayCong / TinhLuong.SO_GIO_LAM_CHUAN.getHeSo();
        }
        return null;
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
