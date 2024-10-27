package com.fpt.vanguard.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ViTriTuyenDungDtoResponse {
    private String maViTriTuyenDung;
    private String tenViTri;
    private String maPhongBan;
    private Integer soLuongTuyen;
    private Integer soLuongUngTuyen;
    private String trangThai;
    private String moTa;
    private String yeuCau;

    // join
    private String tenPhongBan;
}
