package com.fpt.vanguard.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BangLuong {
    private String maBangLuong;
    private String maNhanVien;
    private String tenNhanVien;
    private Double tongLuong;
    private Double tongLuongThucNhan;
    private Double tongPhuCap;
    private Double tongKhauTru;
    private Integer thangBangLuong;
    private Integer namBangLuong;

    private String mucLuong;
    private Integer soNhanVien;
    private String thangNam;
}
