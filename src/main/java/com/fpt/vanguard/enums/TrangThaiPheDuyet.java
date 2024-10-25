package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrangThaiPheDuyet {
    CHO_DUYET(1, "Chờ duyệt"),
    DA_DUYET(2, "Đã duyệt"),
    TU_CHOI(3, "Từ chối");

    private final Integer trangThaiPheDuyet;
    private final String tenTrangThai;

    public static String getTenTrangThai(Integer trangThai) {
        for (TrangThaiPheDuyet e : TrangThaiPheDuyet.values()) {
            if (e.getTrangThaiPheDuyet().equals(trangThai)) {
                return e.getTenTrangThai();
            }
        }
        return "Unknown";
    }
}
