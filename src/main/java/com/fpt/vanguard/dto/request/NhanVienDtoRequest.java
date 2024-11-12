package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class NhanVienDtoRequest {
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
    private Integer userId;
}
