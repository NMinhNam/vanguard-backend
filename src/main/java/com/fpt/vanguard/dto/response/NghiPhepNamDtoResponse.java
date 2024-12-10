package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NghiPhepNamDtoResponse {
    private String maNhanVien;
    private Integer nam;
    private Integer tongSoNgayPhepNam;
    private Integer tongSoNgayDaNghi;
    private Integer tongSoNgayPhepCongDon;
}
