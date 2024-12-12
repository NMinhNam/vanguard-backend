package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoaiCongDtoRequest {
    private String tenLoaiCong;
    private Float heSo;
    private String gioBatDau;
    private String gioKetThuc;
}
