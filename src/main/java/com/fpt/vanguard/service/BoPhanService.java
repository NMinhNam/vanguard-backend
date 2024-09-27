package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.BoPhanDtoRequest;
import com.fpt.vanguard.dto.response.BoPhanDtoResponse;
import com.fpt.vanguard.entity.BoPhan;

import java.util.List;

public interface BoPhanService {
    List<BoPhanDtoResponse> getAllBoPhan();

    BoPhanDtoResponse findBoPhanByMaBoPhan(String maBoPhan);

    int saveBoPhan(BoPhanDtoRequest boPhan);

    int deleteBoPhan(String maBoPhan);
}
