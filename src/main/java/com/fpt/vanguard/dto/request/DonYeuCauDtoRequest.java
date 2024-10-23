package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonYeuCauDtoRequest {
    private Integer maDon;
    private String maNhanVien;
    private String loaiDon;
    private String liDo;
    private String trangThai;
}
