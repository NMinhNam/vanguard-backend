package com.fpt.vanguard.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PheDuyetDtoRequest {
    private String maDon;
    private String maNhanVien;
    private Integer trangThai;
}
