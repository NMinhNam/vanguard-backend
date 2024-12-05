package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@AllArgsConstructor
public enum TrangThaiUngVien {
    CHO_DUYET(1,"Chờ duyệt"),
    PHONG_VAN_LAN_1(2,"Phỏng vấn lần 1"),
    PHONG_VAN_LAN_2(3,"Phỏng vấn lần 2"),
    NHAN_VIEC(4,"Đậu phỏng vấn"),
    TU_CHOI(5,"Rớt phỏng vấn")
    ;

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
