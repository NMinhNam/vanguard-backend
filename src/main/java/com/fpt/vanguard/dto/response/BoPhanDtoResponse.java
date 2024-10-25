package com.fpt.vanguard.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoPhanDtoResponse {
    private String maBoPhan;
    private String tenBoPhan;
}
