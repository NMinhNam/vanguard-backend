package com.fpt.vanguard.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PhongBanDtoRequest {
    private String maPhongBan;
    private String tenPhongBan;
    private String truongPhong;
}
