package com.fpt.vanguard.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PhongBanDtoResponse {
    private String maPhongBan;
    private String tenPhongBan;
    private String truongPhong;
    private String maPhongBanCapTren;

    // Join column SQL
    private Integer soLuongNhanVien;
    private String anhTruongPhong;
    private Double tongLuong;
    private String ngayKy;
}
