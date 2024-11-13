package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChamCongDtoRequest {
    private String maNhanVien;
    private Integer maLoaiCong;
    private String ngayChamCong;
    private String gioVao;
    private String gioRa;
    private Double soGioLam;
}
