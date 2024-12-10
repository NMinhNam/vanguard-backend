package com.fpt.vanguard.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CuocHopDtoRequest {
    private String maCuocHop;
    private String tenCuocHop;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime thoiGianBatDau;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime thoiGianKetThuc;
    private String viTri;
    private String videoCallUrl;
    private String nguoiToChuc;
    private String ghiChu;

    private String maNhanVien;
}
