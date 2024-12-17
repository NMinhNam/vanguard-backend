package com.fpt.vanguard.dto.response;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienViPhamDtoResponse {
    private String maNhanVien;
    private String maViPham;
    private LocalDate ngayViPham;

    private String tenViPham;
    private Double soTien;
}
