package com.fpt.vanguard.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class CuocHopDtoRequest {
    private String maCuocHop;
    private String tenCuocHop;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private String viTri;
    private String videoCallUrl;
    private String nguoiToChuc;
    private String ghiChu;

    private String maNhanVien;
    private String tenNhanVien;
    private String tenNguoiToChuc;
    private String emailNhanVien;
    private List<String> danhSachMaNhanVien;

    public CuocHopDtoRequest(String maCuocHop, String maNhanVien) {
        this.maCuocHop = maCuocHop;
        this.maCuocHop = maNhanVien;
    }
}
