package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NgayNghiPhep {
    SO_NGAY_PHEP_KHI_LAM_DU_NAM(12, "số ngày phép khi làm đủ 1 năm"),
    SO_NGAY_DA_NGHI_MAC_DINH(0, "số ngày đã nghỉ mặc định"),
    SO_NGAY_PHEP_CONG_DON_MAC_DINH(0, "số ngày phép cộng dồn mặc định")
    ;

    private final Integer soNgayNghi;
    private final String loaiNgayNghi;
}
