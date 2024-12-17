package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChamCongDtoResponse {
    private Integer maChamCong;
    private String maNhanVien;
    private Integer maLoaiCong;
    private String ngayChamCong;
    private String gioVao;
    private String gioRa;
    private Double soGioLam;

    private String tenNhanVien;
    private String tenLoaiCong;

    private Integer thang;
    private Integer nam;
    private Double soNgayCong;
}
