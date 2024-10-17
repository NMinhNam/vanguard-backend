package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhongBan {
    private String maPhongBan;
    private String tenPhongBan;
    private String truongPhong;

    // Số lượng nhân viên trong phòng ban, được tính từ kết quả truy vấn SQL.
    private Integer soLuongNhanVien;
}
