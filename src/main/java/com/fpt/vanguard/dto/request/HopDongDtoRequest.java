package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HopDongDtoRequest {
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
