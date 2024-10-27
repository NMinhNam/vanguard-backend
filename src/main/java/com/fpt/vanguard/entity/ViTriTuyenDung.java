package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViTriTuyenDung {
    private String maViTriTuyenDung;
    private String tenViTri;
    private String maPhongBan;
    private Integer soLuongTuyen;
    private Integer soLuongUngTuyen;
    private Boolean trangThai;
    private String moTa;
    private String yeuCau;

    // join
    private String tenPhongBan;
}
