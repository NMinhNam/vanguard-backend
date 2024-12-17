package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CuocHopDtoResponse {
    private String maCuocHop;
    private String tenCuocHop;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private String viTri;
    private String videoCallUrl;
    private String nguoiToChuc;
    private String ghiChu;

    private String tenNguoiToChuc;
    private String danhSachThamGia;
}
