package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class BangChamCong {
    private Integer maChamCong;
    private String maNhanVien;
    private Integer maLoaiCong;
    private LocalDate ngayChamCong;
    private LocalTime gioVao;
    private LocalTime gioRa;
    private Double soGioLam;

    private String tenNhanVien;
    private String tenLoaiCong;
}
