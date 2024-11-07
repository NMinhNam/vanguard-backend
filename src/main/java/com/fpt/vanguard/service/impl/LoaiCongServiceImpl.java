package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.entity.LoaiCong;
import com.fpt.vanguard.entity.NgayLe;
import com.fpt.vanguard.mapper.mybatis.NgayLeMapper;
import com.fpt.vanguard.service.LoaiCongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoaiCongServiceImpl implements LoaiCongService {
    private final NgayLeMapper ngayLeMapper;

    @Override
    public LoaiCong getLoaiCong(LocalDate localDate) {
        Optional<NgayLe> ngayLe = ngayLeMapper.findByNgayLe(localDate);
        if (ngayLe.isPresent()) {
            return
        }

        return null;
    }
}
