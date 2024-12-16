package com.fpt.vanguard.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BangLuongDtoRequest {
    private String maBangLuong;
    private String maNhanVien;
    private Double tongLuong;
    private Double tongPhuCap;
    private Double tongKhauTru;
    private Double tongLuongThucNhan;
    private Integer thang;
    private Integer nam;
}
