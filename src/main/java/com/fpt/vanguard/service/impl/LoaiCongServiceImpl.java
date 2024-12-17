package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.LoaiCongDtoRequest;
import com.fpt.vanguard.dto.response.LoaiCongDtoResponse;
import com.fpt.vanguard.enums.LoaiNgayCong;
import com.fpt.vanguard.mapper.mapstruct.LoaiCongMapstruct;
import com.fpt.vanguard.mapper.mybatis.LoaiCongMapper;
import com.fpt.vanguard.mapper.mybatis.NgayLeMapper;
import com.fpt.vanguard.service.LoaiCongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoaiCongServiceImpl implements LoaiCongService {
    private final NgayLeMapper ngayLeMapper;
    private final LoaiCongMapper loaiCongMapper;
    private final LoaiCongMapstruct loaiCongMapstruct;

    @Override
    public Integer getLoaiCong(String ngayChamCong) {
        Boolean isNgayLe = ngayLeMapper.isNgayLe(ngayChamCong);
        LocalDate ngayLe = LocalDate.parse(ngayChamCong, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (ngayLe.getDayOfWeek() == DayOfWeek.SATURDAY || ngayLe.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return LoaiNgayCong.CUOI_TUAN.getMaLoaiNgayCong();
        }

        if (isNgayLe) return LoaiNgayCong.NGAY_LE.getMaLoaiNgayCong();

        return LoaiNgayCong.NGAY_THUONG.getMaLoaiNgayCong();
    }

    @Override
    public Integer saveLoaiCong(LoaiCongDtoRequest loaiCongDtoRequest) {
        String tenLoaiCong = loaiCongDtoRequest.getTenLoaiCong();
        Boolean isExistLoaiCong = loaiCongMapper.isLoaiCongExist(tenLoaiCong);

        if (isExistLoaiCong) return loaiCongMapper.updateLoaiCong(loaiCongMapstruct.toLoaiCong(loaiCongDtoRequest));
        return loaiCongMapper.insertLoaiCong(loaiCongMapstruct.toLoaiCong(loaiCongDtoRequest));
    }

    @Override
    public Integer deleteLoaiCong(String tenLoaiCong) {
        return loaiCongMapper.deleteLoaiCong(tenLoaiCong);
    }

    @Override
    public List<LoaiCongDtoResponse> getAllLoaiCong() {
        return loaiCongMapstruct.toDtoList(loaiCongMapper.getAllLoaiCongs());
    }

    @Override
    public LoaiCongDtoResponse getLoaiCongByNgay(Integer maLoaiCong) {
        return loaiCongMapstruct.toDtoResponse(loaiCongMapper.getLoaiCongByNgay(maLoaiCong));
    }
}
