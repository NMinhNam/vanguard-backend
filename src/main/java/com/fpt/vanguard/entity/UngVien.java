package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UngVien {
    private String maUngVien;
    private String hoTen;
    private Boolean gioiTinh;
    private String ngaySinh;
    private String dienThoai;
    private String cccd;
    private String diaChi;
    private String hinhAnh;
    private String email;
    private String maViTriTuyenDung;
    private Integer trangThai;

    private LocalDate ngayPhongVan;
    private String diaDiemPhongVan;
    private LocalDate ngayBatDauLam;
}
