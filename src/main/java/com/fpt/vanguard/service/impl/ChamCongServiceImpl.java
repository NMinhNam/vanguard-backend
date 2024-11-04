package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.mapper.mybatis.ChamCongMapper;
import com.fpt.vanguard.service.ChamCongService;
import com.fpt.vanguard.service.LoaiCongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChamCongServiceImpl implements ChamCongService {
    private final ChamCongMapper chamCongMapper;
    private final LoaiCongService loaiCongService;

    @Override
    public Integer doCheckIn() {


        return 0;
    }

    @Override
    public Integer doCheckOut() {
        return 0;
    }
}
