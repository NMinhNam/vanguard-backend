package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LichSuCongViecDtoRequest {
    private String maNhanVien;
    private String tenCongTy;
    private String viTri;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private String moTaCongViec;
}
