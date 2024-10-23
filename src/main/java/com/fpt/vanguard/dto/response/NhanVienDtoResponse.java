package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class NhanVienDtoResponse {
    private String maNhanVien;
    private String hoTen;
    private Boolean gioiTinh;
    private String ngaySinh;
    private String dienThoai;
    private String cccd;
    private String diaChi;
    private String hinhAnh;
    private String email;
    private String maPhongBan;
    private String maBoPhan;
    private String maChucVu;
    private String maTrinhDo;
    private Integer userId;

    private String tenTruongPhong;
}
