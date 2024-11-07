package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BangChamCong {
    private Integer maChamCong;
    private String maNhanVien;
    private String maLoaiCong;
    private String ngayChamCong;
    private Date gioVao;
    private Date gioRa;
    private Integer soGioLam;

    private String tenNhanVien;
}
