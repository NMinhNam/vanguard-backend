package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ChamCongDtoRequest {
    private String maNhanVien;
    private Integer maLoaiCong;
    private LocalDate ngayChamCong;
    private LocalTime gioVao;
    private LocalTime gioRa;
    private Double soGioLam;
}
