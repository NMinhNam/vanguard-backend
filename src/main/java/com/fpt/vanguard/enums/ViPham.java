package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ViPham {
    DI_TRE("VP0001","Đi trễ"),
    VE_SOM("VP0002","Về sớm"),
    ;

    private final String maViPham;
    private final String tenViPham;
}
