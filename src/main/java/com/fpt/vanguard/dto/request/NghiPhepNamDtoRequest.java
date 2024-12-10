package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NghiPhepNamDtoRequest {
    private String maNhanVien;
    private Integer nam;
    private Integer tongSoNgayPhepNam;
    private Integer tongSoNgayDaNghi;
    private Integer tongSoNgayPhepCongDon;
}
