package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class NhanVienPhuCap {
    private String maPhuCap;
    private String maNhanVien;
    private LocalDate ngay;
}
