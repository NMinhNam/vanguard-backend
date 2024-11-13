package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BangChamCong {
    private Integer maChamCong;
    private String maNhanVien;
    private Integer maLoaiCong;
    private String ngayChamCong;
    private String gioVao;
    private String gioRa;
    private Double soGioLam;

    private String tenNhanVien;
    private String tenLoaiCong;
}
