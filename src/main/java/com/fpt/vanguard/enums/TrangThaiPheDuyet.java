package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrangThaiPheDuyet {
    CHO_DUYET(1),
    DA_DUYET(2),
    TU_CHOI(3);

    private final Integer trangThaiPheDuyet;
}
