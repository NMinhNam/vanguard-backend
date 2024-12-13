package com.fpt.vanguard.dto.request;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NhanVienViPhamDtoRequest {
    private String maNhanVien;
    private String maViPham;
    private LocalDate ngayViPham;
}
