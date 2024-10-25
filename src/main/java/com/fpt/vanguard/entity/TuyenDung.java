package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TuyenDung {
    private String maTuyenDung;
    private String tenViec;              // Tên công việc
    private String maPhongBan;           // Mã phòng ban
    private Integer soLuongTuyen;        // Số lượng cần tuyển
    private Integer soLuongUngTuyen;     // Số lượng ứng tuyển
    private String trangThai;             // Trạng thái công việc
    private String moTa;                  // Mô tả công việc
    private String yeuCau;                // Yêu cầu công việc
}
