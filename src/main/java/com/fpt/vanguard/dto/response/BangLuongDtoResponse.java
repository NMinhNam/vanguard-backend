package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BangLuongDtoResponse {
    private String maBangLuong;
    private String maNhanVien;
    private String tenNhanVien;
    private Double tongLuong;
    private Double tongLuongThucNhan;
    private Double tongPhuCap;
    private Double tongKhauTru;
    private Integer thang;
    private Integer nam;

    private String mucLuong;
    private Integer soNhanVien;
    private String thangNam;
}
