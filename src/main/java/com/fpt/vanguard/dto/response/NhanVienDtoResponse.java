package com.fpt.vanguard.dto.response;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienDtoResponse {
    private String maNhanVien;
    private String hoTen;
    private Boolean gioiTinh;
    private String ngaySinh;
    private String dienThoai;
    private String cccd;
    private String diaChi;
    private MultipartFile hinhAnh;
    private String hinhAnhUrl;
    private String email;
    private String maPhongBan;
    private String maBoPhan;
    private String maChucVu;
    private Integer userId;

    private String tenTruongPhong;
    private String tenPhongBan;
    private String tenBoPhan;
    private String tenChucVu;
}
