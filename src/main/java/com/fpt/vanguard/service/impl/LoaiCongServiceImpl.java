package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.entity.NgayLe;
import com.fpt.vanguard.enums.LoaiNgayCong;
import com.fpt.vanguard.mapper.mybatis.NgayLeMapper;
import com.fpt.vanguard.service.LoaiCongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class LoaiCongServiceImpl implements LoaiCongService {
    private final NgayLeMapper ngayLeMapper;

    @Override
    public Integer getLoaiCong(String ngayChamCong) {
        Boolean isNgayLe = ngayLeMapper.isNgayLe(ngayChamCong);
        LocalDate ngayLe = LocalDate.parse(ngayChamCong, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (ngayLe.getDayOfWeek() == DayOfWeek.SATURDAY ||
                ngayLe.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return LoaiNgayCong.CUOI_TUAN.getMaLoaiNgayCong();
        }

        if (isNgayLe) return LoaiNgayCong.NGAY_LE.getMaLoaiNgayCong();

        return LoaiNgayCong.NGAY_THUONG.getMaLoaiNgayCong();
    }
}
