package com.fpt.vanguard.entity;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
public class NhanVienViPham {
    private String maNhanVien;
    private String maViPham;
    private LocalDate ngayViPham;

    private String tenViPham;
    private String tenNhanVienViPham;
    private Double soTien;
}
