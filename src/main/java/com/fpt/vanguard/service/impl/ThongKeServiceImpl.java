package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.*;
import com.fpt.vanguard.mapper.mapstruct.*;
import com.fpt.vanguard.mapper.mybatis.*;
import com.fpt.vanguard.service.ThongKeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThongKeServiceImpl implements ThongKeService {
    private final PhongBanMapper phongBanMapper;
    private final PhongBanMapstruct phongBanMapstruct;
    private final DonYeuCauMapper donYeuCauMapper;
    private final DonYeuCauMapstruct donYeuCauMapstruct;
    private final BangLuongMapper bangLuongMapper;
    private final BangLuongMapstruct bangLuongMapstruct;
    private final NhanVienMapper nhanVienMapper;
    private final NhanVienMapstruct nhanVienMapstruct;
    private final HocVanMapper hocVanMapper;
    private final HocVanMapstruct hocVanMapstruct;

    @Override
    public List<PhongBanDtoResponse> getSoLuongNhanVienTheoPhongBan() {
        return phongBanMapstruct.toPhongBanDtoResponseList(
                phongBanMapper.getSoLuongNhanVienTheoPhongBan()
        );
    }

    @Override
    public List<DonYeuCauDtoResponse> getDonYeuCau() {
        return donYeuCauMapstruct.toListResponseDto(
                donYeuCauMapper.getDonYeuCau()
        );
    }

    @Override
    public List<BangLuongDtoResponse> getSoLuongNhanVienTheoMucLuong() {
        return bangLuongMapstruct.toResponseList(
                bangLuongMapper.getMucLuongTheoSoLuongNhanVien()
        );
    }

    @Override
    public List<PhongBanDtoResponse> getTongLuongTheoPhongBan() {
        return phongBanMapstruct.toPhongBanDtoResponseList(
                phongBanMapper.getTongLuongTheoPhongBan()
        );
    }

    @Override
    public List<PhongBanDtoResponse> getBienDongNhanVienTheoPhongBan() {
        return phongBanMapstruct.toPhongBanDtoResponseList(
                phongBanMapper.getBienDongNhanVienTheoPhongBan()
        );
    }

    @Override
    public List<NhanVienDtoResponse> getNhanSuMoi() {
        return nhanVienMapstruct.toNhanVienDtoResponseList(
                nhanVienMapper.getNhanSuMoi()
        );
    }

    @Override
    public List<NhanVienDtoResponse> getNhanVienSinhNhat() {
        return nhanVienMapstruct.toNhanVienDtoResponseList(
                nhanVienMapper.getNhanVienByBirthday()
        );
    }

    @Override
    public List<HocVanDtoResponse> getSoLuongNhanVienTheoHocVan() {
        return hocVanMapstruct.toHocVanDtoResponseList(
                hocVanMapper.getSoLuongNhanVienTheoHocVan()
        );
    }

    @Override
    public List<BangLuongDtoResponse> getTongLuongNhanVienTheoThang(String maNhanVien) {
        return bangLuongMapstruct.toResponseList(
                bangLuongMapper.getTongLuongNhanVienTheoThang(maNhanVien)
        );
    }
}
