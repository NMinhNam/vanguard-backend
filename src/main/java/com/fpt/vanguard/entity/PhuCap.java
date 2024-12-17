package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PhuCap {
    private String maPhuCap;
    private String tenPhuCap;
    private Double soTien;

    private String maNhanVien;
    private String tenNhanVien;
    private Date ngay;
}
