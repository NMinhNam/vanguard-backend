package com.fpt.vanguard.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NghiPhepNamDtoRequest {
    private String maNhanVien;
    private Integer nam;
    private Integer tongSoNgayPhepNam;
    private Integer tongSoNgayDaNghi;
    private Integer tongSoNgayPhepCongDon;
    private Integer tongSoNgayPhepCon;
}
