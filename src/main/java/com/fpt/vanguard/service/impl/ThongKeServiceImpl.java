package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.BangLuongDtoResponse;
import com.fpt.vanguard.dto.response.DonYeuCauDtoResponse;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.BangLuongMapstruct;
import com.fpt.vanguard.mapper.mapstruct.DonYeuCauMapstruct;
import com.fpt.vanguard.mapper.mapstruct.NhanVienMapstruct;
import com.fpt.vanguard.mapper.mapstruct.PhongBanMapstruct;
import com.fpt.vanguard.mapper.mybatis.BangLuongMapper;
import com.fpt.vanguard.mapper.mybatis.DonYeuCauMapper;
import com.fpt.vanguard.mapper.mybatis.NhanVienMapper;
import com.fpt.vanguard.mapper.mybatis.PhongBanMapper;
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
}
