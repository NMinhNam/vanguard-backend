package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HopDongDtoResponse {
    private String soHopDong;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private LocalDate ngayKy;
    private String noiDung;
    private Integer lanKy;
    private Integer thoiHan;
    private Double heSoLuong;
    private String maNhanVien;
}
