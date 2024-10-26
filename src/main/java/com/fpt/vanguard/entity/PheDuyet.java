package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PheDuyet {
    private Integer maPheDuyet;
    private String maDon;
    private String maNhanVien;
    private Integer trangThai;
    private String ghiChu;
    private String ngayPheDuyet;

    // entity join
    private String hoTenNguoiPheDuyet;
    private String hoTenNguoiTao;
    private String loaiDon;
    private String ngayTao;
}
