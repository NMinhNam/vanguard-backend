package com.fpt.vanguard.service;

import com.fpt.vanguard.entity.LoaiCong;

import java.time.LocalDate;

public interface LoaiCongService {
    LoaiCong getLoaiCong(LocalDate localDate);
}
