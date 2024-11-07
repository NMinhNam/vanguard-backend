package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class ChamCongDtoResponse {
    private String ngayChamCong;
    private String gioVao;
    private String gioRa;
    private Double soGioLam;
    private String maNhanVien;

    private String tenLoaiCong;
    private String tenNhanVien;
}
