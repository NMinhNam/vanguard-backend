package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhuCapDtoRequest {
    private String maPhuCap;
    private String tenPhuCap;
    private Double soTien;

    private String maNhanVien;
}
