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
    private Double tongKhauTru;
    private Double tongLuongThucNhan;
    private Integer thang;
    private Integer nam;
}
