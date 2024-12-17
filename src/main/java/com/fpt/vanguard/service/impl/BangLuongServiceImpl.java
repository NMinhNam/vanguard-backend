package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.BangLuongDtoRequest;
import com.fpt.vanguard.dto.response.BangLuongDtoResponse;
import com.fpt.vanguard.entity.BangLuong;
import com.fpt.vanguard.enums.TinhLuong;
import com.fpt.vanguard.mapper.mapstruct.BangLuongMapstruct;
import com.fpt.vanguard.mapper.mybatis.BangLuongMapper;
import com.fpt.vanguard.mapper.mybatis.HopDongMapper;
import com.fpt.vanguard.mapper.mybatis.NhanVienMapper;
import com.fpt.vanguard.service.BangLuongService;
import com.fpt.vanguard.service.ChamCongService;
import com.fpt.vanguard.service.PhuCapService;
import com.fpt.vanguard.service.ViPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BangLuongServiceImpl implements BangLuongService {
    private final ChamCongService chamCongService;
    private final HopDongMapper hopDongMapper;
    private final PhuCapService phuCapService;
    private final ViPhamService viPhamService;
    private final BangLuongMapper bangLuongMapper;
    private final BangLuongMapstruct bangLuongMapstruct;
    private final NhanVienMapper nhanVienMapper;

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
    public Integer saveBangLuong(BangLuongDtoRequest request) {
        String maNhanVien = request.getMaNhanVien();

        return 0;
    }

    @Override
    public BangLuongDtoResponse getBangLuongNhanVienByMonth(String maNhanVien) {
        Integer thang = LocalDate.now().getMonthValue();
        Integer nam = LocalDate.now().getYear();
        return bangLuongMapstruct.toDtoResponse(
                bangLuongMapper.getBangLuongNhanVienByMonth(maNhanVien, thang, nam)
        );
    }

    @Override
    public Integer updateBangLuongTinhLuong() {
        Integer thang = LocalDate.now().getMonthValue();
        Integer nam = LocalDate.now().getYear();

        List<String> danhSachNhanVien = nhanVienMapper.getAllMaNhanVien();
        int soLuongNhanVienDuocTinhLuong = 0;

        for (String maNhanVien : danhSachNhanVien) {
            Boolean isExistBangLuong = bangLuongMapper.isBangLuongExist(maNhanVien, thang, nam);
            if (!isExistBangLuong) {
                BangLuong bangLuong = BangLuong.builder()
                        .maNhanVien(maNhanVien)
                        .thangBangLuong(thang)
                        .namBangLuong(nam)
                        .build();
                bangLuongMapper.insertBangLuongNhanVien(bangLuong);
            }

            Boolean isTinhLuong = bangLuongMapper.isTinhLuong(maNhanVien, thang, nam);
            if (!isTinhLuong) {
                BangLuongDtoResponse response = tinhLuongThang(maNhanVien, thang, nam);
                response.setMaNhanVien(maNhanVien);
                bangLuongMapper.updateBangLuongNhanVien(
                        bangLuongMapstruct.toBangLuong(response)
                );
                soLuongNhanVienDuocTinhLuong++;
            }
        }

        return soLuongNhanVienDuocTinhLuong;
    }

    private BangLuongDtoResponse tinhLuongThang(String maNhanVien, Integer thang, Integer nam) {
        Double luongCoBan = hopDongMapper.getLuongCoBanByMaNhanVien(maNhanVien);
        if (luongCoBan == null) {
            luongCoBan = 0.0;
        }
        Double tongPhuCap = phuCapService.getSumNhanVienPhuCapByMonth(maNhanVien, thang, nam);
        if (tongPhuCap == null) {
            tongPhuCap = 0.0;
        }
        Double tongKhauTru = viPhamService.getSumNhanVienViPhamByMonth(maNhanVien, thang, nam);
        if (tongKhauTru == null) {
            tongKhauTru = 0.0;
        }
        Double soNgayCongThucTe = chamCongService.tinhSoNgayCong(maNhanVien, thang, nam);
        if (soNgayCongThucTe == null) {
            soNgayCongThucTe = 0.0;
        }
        Double soTienLuong = (luongCoBan / TinhLuong.SO_NGAY_CONG_CHUAN.getHeSo()) * soNgayCongThucTe;
        Double soTienLuongThucTe = soTienLuong + tongPhuCap - tongKhauTru;

        return BangLuongDtoResponse.builder()
                .tongPhuCap(tongPhuCap)
                .tongKhauTru(tongKhauTru)
                .tongLuong(soTienLuong)
                .tongLuongThucNhan(soTienLuongThucTe)
                .build();
    }
}
