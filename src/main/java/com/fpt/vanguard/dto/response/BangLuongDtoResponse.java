package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BangLuongDtoResponse {
    private String maBangLuong;
    private String maNhanVien;
    private Double tongLuong;
    private Double tongPhuCap;
    private Integer thang;
    private Integer nam;

    private String mucLuong;
    private Integer soNhanVien;
}
