package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonYeuCau {
    private String maDon;
    private String maNhanVien;
    private String loaiDon;
    private String moTa;
    private Integer trangThai;
    private String ngayTao;
    private String ngayBatDau;
    private String ngayKetThuc;
}
