package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ChamCongDtoResponse {
    private Integer maChamCong;
    private String maNhanVien;
    private Integer maLoaiCong;
    private LocalDate ngayChamCong;
    private LocalTime gioVao;
    private LocalTime gioRa;
    private Double soGioLam;

    private String tenNhanVien;
    private String tenLoaiCong;
}
