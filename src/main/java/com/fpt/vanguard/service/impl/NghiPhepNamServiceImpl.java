package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.NghiPhepNamDtoRequest;
import com.fpt.vanguard.dto.response.NghiPhepNamDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.enums.NgayNghiPhep;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.NghiPhepNamMapstruct;
import com.fpt.vanguard.mapper.mybatis.NghiPhepNamMapper;
import com.fpt.vanguard.service.HopDongService;
import com.fpt.vanguard.service.NghiPhepNamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class NghiPhepNamServiceImpl implements NghiPhepNamService {
    private final NghiPhepNamMapper nghiPhepNamMapper;
    private final NghiPhepNamMapstruct nghiPhepNamMapstruct;
    private final HopDongService hopDongService;

    @Override
    public NghiPhepNamDtoResponse getNgayNghiPhepNam(String maNhanVien) {
        Integer nam = LocalDateTime.now().getYear();

        return nghiPhepNamMapstruct.toDtoResponse(nghiPhepNamMapper.getNghiPhepNam(maNhanVien, nam));
    }

    @Override
    public Integer updateNgayPhepKhiXinNghi(String maNhanVien, Integer soNgayNghi) {
        Integer namHienTai = LocalDateTime.now().getYear();
        Integer soNgayPhepNamHienTai = nghiPhepNamMapper.getNghiPhepNam(maNhanVien, namHienTai).getTongSoNgayPhepCon();
        if (soNgayPhepNamHienTai < soNgayNghi) throw new AppException(ErrorCode.KHONG_DU_SO_NGAY_PHEP_NAM);
        return nghiPhepNamMapper.updateTongSoNgayPhepNam(maNhanVien, namHienTai, soNgayNghi);
    }

    @Override
    public Integer createNghiPhepNamChoNhanVienMoi(NghiPhepNamDtoRequest nghiPhepNamDtoRequest) {
        String maNhanVien = nghiPhepNamDtoRequest.getMaNhanVien();

        LocalDate ngayBatDau = hopDongService.getHopDongByMaNhanVien(maNhanVien).getNgayBatDau();
        LocalDate ngayHienTai = LocalDate.now();
        long thangLamViecThucTe = ChronoUnit.MONTHS.between(ngayBatDau, ngayHienTai);

        int soNgayNghiPhepThucTe = Math.round(((float) NgayNghiPhep.SO_NGAY_PHEP_KHI_LAM_DU_NAM.getSoNgayNghi() / 12) * thangLamViecThucTe);
        Integer namHienTai = LocalDate.now().getYear();
        Boolean isExistNghiPhepNam = nghiPhepNamMapper.isExistNghiPhepNam(maNhanVien, namHienTai);
        if (isExistNghiPhepNam) throw new AppException(ErrorCode.NGHI_PHEP_NAM_EXISTED);

        nghiPhepNamDtoRequest = NghiPhepNamDtoRequest.builder().maNhanVien(maNhanVien).nam(namHienTai).tongSoNgayPhepNam(soNgayNghiPhepThucTe).tongSoNgayDaNghi(NgayNghiPhep.SO_NGAY_DA_NGHI_MAC_DINH.getSoNgayNghi()).tongSoNgayPhepCongDon(NgayNghiPhep.SO_NGAY_PHEP_CONG_DON_MAC_DINH.getSoNgayNghi()).tongSoNgayPhepCon(soNgayNghiPhepThucTe).build();

        return nghiPhepNamMapper.insertNghiPhepNam(nghiPhepNamMapstruct.toNghiPhepNam(nghiPhepNamDtoRequest));
    }

    @Override
    public Integer updateNghiPhepNamChoNamMoi(NghiPhepNamDtoRequest nghiPhepNamDtoRequest) {
        Integer namHienTai = nghiPhepNamDtoRequest.getNam();
        Integer namTruoc = namHienTai - 1;
        String maNhanVien = nghiPhepNamDtoRequest.getMaNhanVien();
        Integer tongSoNgayPhepCon = nghiPhepNamMapper.getNghiPhepNam(maNhanVien, namTruoc).getTongSoNgayPhepCon();
        tongSoNgayPhepCon = tongSoNgayPhepCon != null ? tongSoNgayPhepCon : 0;

        Integer soNgayPhepNamMoi = NgayNghiPhep.SO_NGAY_PHEP_KHI_LAM_DU_NAM.getSoNgayNghi();
        Integer tongSoNgayNghiPhep = tongSoNgayPhepCon + soNgayPhepNamMoi;

        NghiPhepNamDtoRequest request = NghiPhepNamDtoRequest.builder().tongSoNgayPhepCon(tongSoNgayNghiPhep).nam(namHienTai).maNhanVien(maNhanVien).build();

        return nghiPhepNamMapper.updateTongSoNgayPhepCon(nghiPhepNamMapstruct.toNghiPhepNam(request));
    }
}
