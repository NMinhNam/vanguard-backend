package com.fpt.vanguard.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoPhanDtoRequest {
    private String maBoPhan;
    private String tenBoPhan;
}
