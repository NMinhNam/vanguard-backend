package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TinhLuong {
    SO_NGAY_CONG_CHUAN(26.0, "Số ngày công chuẩn mỗi tháng"),
    SO_GIO_LAM_CHUAN(8.0, "Số giờ làm chuẩn mỗi ngày"),
    ;

    private final Double heSo;
    private final String tenHeSo;
}
