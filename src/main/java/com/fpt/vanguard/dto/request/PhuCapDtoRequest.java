package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PhuCapDtoRequest {
    private String maPhuCap;
    private String tenPhuCap;
    private Double soTien;
    private LocalDate ngay;

    private String maNhanVien;
}
