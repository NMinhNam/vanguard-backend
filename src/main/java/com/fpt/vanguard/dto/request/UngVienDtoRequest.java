package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UngVienDtoRequest {
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

    private String tenViTri;
    private LocalDate ngayPhongVan;
    private String diaDiemPhongVan;
    private LocalDate ngayBatDauLam;
}
