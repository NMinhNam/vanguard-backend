package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PheDuyetDtoResponse {
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
