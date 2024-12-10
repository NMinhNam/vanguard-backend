package com.fpt.vanguard.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CuocHop {
    private String maCuocHop;
    private String tenCuocHop;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private String viTri;
    private String videoCallUrl;
    private String nguoiToChuc;
    private String ghiChu;

    //JOIN
    private String tenNguoiToChuc;
    private String danhSachThamGia;
}
