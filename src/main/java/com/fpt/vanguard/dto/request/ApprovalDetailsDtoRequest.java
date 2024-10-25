package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApprovalDetailsDtoRequest {
    private String emailNguoiPheDuyet;
    private String emailNguoiTao;
    private String hoTenNguoiPheDuyet;
    private String hoTenNguoiTao;
    private String loaiDon;
    private String ngayTao;
    private String lyDo;
    private Integer trangThai;
}
