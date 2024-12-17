package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.PhuCapDtoRequest;

public interface NhanVienPhuCapService {
    Integer insertNhanVienPhuCap(PhuCapDtoRequest phuCapDtoRequest);
    Integer deteleNhanVienPhuCap(PhuCapDtoRequest phuCapDtoRequest);
}
