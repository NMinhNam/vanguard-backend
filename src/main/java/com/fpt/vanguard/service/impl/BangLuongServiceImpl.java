package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.BangLuongDtoRequest;
import com.fpt.vanguard.dto.response.BangLuongDtoResponse;
import com.fpt.vanguard.entity.BangLuong;
import com.fpt.vanguard.enums.TinhLuong;
import com.fpt.vanguard.mapper.mapstruct.BangLuongMapstruct;
import com.fpt.vanguard.mapper.mybatis.BangLuongMapper;
import com.fpt.vanguard.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        Boolean isExistBangLuong = bangLuongMapper.isBangLuongExist(maNhanVien);
        Integer thang = LocalDate.now().getMonthValue();
        Integer nam = LocalDate.now().getYear();
        BangLuong bangLuong = BangLuong.builder()
                .maNhanVien(maNhanVien)
                .thang(thang)
                .nam(nam)
                .build();
        if (!isExistBangLuong) {
            bangLuongMapper.insertBangLuongNhanVien(bangLuong);
        }

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
        Boolean isExistBangLuong = bangLuongMapper.isBangLuongExist(maNhanVien);
        Integer thang = LocalDate.now().getMonthValue();
        Integer nam = LocalDate.now().getYear();

        if (!isExistBangLuong) {
            BangLuong bangLuong = BangLuong.builder()
                    .maNhanVien(maNhanVien)
                    .thang(thang)
                    .nam(nam)
                    .build();
            bangLuongMapper.insertBangLuongNhanVien(bangLuong);
        }

        Boolean isTinhLuong = bangLuongMapper.isTinhLuong()
        if ()

        return bangLuongMapstruct.toDtoResponse(
                bangLuongMapper.getBangLuongNhanVienByMonth(bangLuong)
        );
    }

    private BangLuongDtoRequest tinhLuongThang(String maNhanVien, Integer thang, Integer nam) {
        Double luongCoBan = hopDongService.getHopDongByMaNhanVien(maNhanVien).getLuongCoBan();
        Double tongPhuCap = phuCapService.getSumNhanVienPhuCapByMonth(maNhanVien, thang, nam);
        if (tongPhuCap == null) {
            tongPhuCap = 0.0;
        }
        Double tongKhauTru = viPhamService.getSumNhanVienViPhamByMonth(maNhanVien, thang, nam);
        if (tongKhauTru == null) {
            tongKhauTru = 0.0;
        }
        Double soNgayCongThucTe = chamCongService.tinhSoNgayCong(maNhanVien, thang, nam);
        Double soTienLuong = (luongCoBan / TinhLuong.SO_NGAY_CONG_CHUAN.getHeSo()) * soNgayCongThucTe;
        Double soTienLuongThucTe = soTienLuong + tongPhuCap - tongKhauTru;

        return BangLuongDtoRequest.builder()
                .tongPhuCap(tongPhuCap)
                .tongKhauTru(tongKhauTru)
                .tongLuong(soTienLuong)
                .tongLuongThucNhan(soTienLuongThucTe)
                .build();
    }
}
