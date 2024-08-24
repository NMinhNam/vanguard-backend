package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import java.util.Date;

@Getter
@Setter
@Builder
public class NhanVienDtoResponse {
    private String maNhanVien;
    private String hoTen;
    private Boolean gioiTinh;
    private Date ngaySinh;
    private String dienThoai;
    private String cccd;
    private String diaChi;
    private String hinhAnh;
    private String maPhongBan;
    private String maBoPhan;
    private String maChucVu;
    private String maTrinhDo;


}
