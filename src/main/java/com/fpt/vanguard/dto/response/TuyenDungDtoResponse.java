package com.fpt.vanguard.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TuyenDungDtoResponse {
    private String maTuyenDung;
    private String tenViec;
    private String maPhongBan;
    private Integer soLuongTuyen;
    private Integer soLuongUngTuyen;
    private String trangThai;
    private String moTa;
    private String yeuCau;
}
