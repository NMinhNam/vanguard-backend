package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
public class PhuCapDtoResponse {
    private String maPhuCap;
    private String tenPhuCap;
    private Double soTien;

    private String maNhanVien;
    private String tenNhanVien;
    private LocalDate ngay;
}
