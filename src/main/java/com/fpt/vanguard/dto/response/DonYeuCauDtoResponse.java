package com.fpt.vanguard.dto.response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonYeuCauDtoResponse {
    private String maDon;
    private String maNhanVien;
    private String loaiDon;
    private String liDo;
    private Integer trangThai;
    private String ngayTao;
}
