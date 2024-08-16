package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class NhanVien {
    private Integer id;
    private String hoVaTen;
    private String viTri;
    private BigDecimal luong;
    private Date ngayThamGia;
}
