package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@AllArgsConstructor
public enum TrangThaiUngVien {
    CHO_DUYET(1,"Chờ duyệt"),
    PHONG_VAN(2,"Phỏng vấn"),
    DAU_PHONG_VAN(3,"Đậu phỏng vấn"),
    ROT_PHONG_VAN(4,"Rớt phỏng vấn");

    private int trangThaiUngVien;
    private String tenTrangThai;

    public static String getTenTrangThai(Integer trangThai) {
        for (TrangThaiUngVien e : TrangThaiUngVien.values()) {
            if (e.getTrangThaiUngVien() == trangThai) {
                return e.getTenTrangThai();
            }
        }
        return "Unknown";
    }
}
