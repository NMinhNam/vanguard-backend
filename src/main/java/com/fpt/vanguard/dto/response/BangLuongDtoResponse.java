package com.fpt.vanguard.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BangLuongDtoResponse {
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
