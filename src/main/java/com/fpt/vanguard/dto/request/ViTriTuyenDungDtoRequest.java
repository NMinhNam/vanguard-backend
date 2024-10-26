package com.fpt.vanguard.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ViTriTuyenDungDtoRequest {
    private String maViTriTuyenDung;
    private String tenViTri;
    private String maPhongBan;
    private Integer soLuongTuyen;
    private Integer soLuongUngTuyen;
    private Boolean trangThai;
    private String moTa;
    private String yeuCau;
}
