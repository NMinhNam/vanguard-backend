package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.BangLuongDtoResponse;
import com.fpt.vanguard.enums.TinhLuong;
import com.fpt.vanguard.mapper.mapstruct.BangLuongMapstruct;
import com.fpt.vanguard.mapper.mybatis.BangLuongMapper;
import com.fpt.vanguard.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BangLuongServiceImpl implements BangLuongService {
    private final ChamCongService chamCongService;
    private final HopDongService hopDongService;
    private final PhuCapService phuCapService;
    private final ViPhamService viPhamService;
    private final BangLuongMapper bangLuongMapper;
    private final BangLuongMapstruct bangLuongMapstruct;

    @Override
    public List<BangLuongDtoResponse> getBangLuongNhanVien(String maNhanVien) {
        return bangLuongMapstruct.toResponseList(
                bangLuongMapper.getBangLuongNhanVien(maNhanVien)
        );
    }

    @Override
    public List<BangLuongDtoResponse> getAllBangLuong() {
        return bangLuongMapstruct.toResponseList(
                bangLuongMapper.getAllBangLuong()
        );
    }

    @Override
    public Integer updateBangLuong() {
        return 0;
    }

    private Double tinhLuongThang(String maNhanVien, String ngay) {
        Double luongCoBan = hopDongService.getHopDongByMaNhanVien(maNhanVien).getLuongCoBan();
        Double tongPhuCap = phuCapService.getSumNhanVienPhuCapByMonth(maNhanVien, ngay);
        if (tongPhuCap == null) {
            tongPhuCap = 0.0;
        }
        Double tongKhauTru = viPhamService.getSumNhanVienViPhamByMonth(maNhanVien, ngay);
        if (tongKhauTru == null) {
            tongKhauTru = 0.0;
        }
        Double soNgayCongThucTe = chamCongService.tinhSoNgayCong(maNhanVien, ngay);
        Double soTienLuong = (luongCoBan/ TinhLuong.SO_NGAY_CONG_CHUAN.getHeSo()) * soNgayCongThucTe;
        return soTienLuong + tongPhuCap - tongKhauTru;
    }
}
