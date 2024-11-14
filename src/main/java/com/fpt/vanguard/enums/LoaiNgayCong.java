package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoaiNgayCong {
    NGAY_THUONG(1, "Ngay thuong"),
    CUOI_TUAN(2, "Cuoi tuan"),
    NGAY_LE(3, "Ngay le");

    private final Integer maLoaiNgayCong;
    private final String tenLoaiNgayCong;
}
