package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhongBan {
    private String maPhongBan;
    private String tenPhongBan;
    private String truongPhong;
    private String maPhongBanCapTren;

    // Join column SQL
    private Integer soLuongNhanVien;
    private String anhTruongPhong;
    private Double tongLuong;
    private String ngayKy;
}
