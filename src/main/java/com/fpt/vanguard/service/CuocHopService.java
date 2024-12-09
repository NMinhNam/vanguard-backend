package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.dto.response.CuocHopDtoResponse;

import java.util.List;

public interface CuocHopService {
    List<CuocHopDtoResponse> getAllCuocHops();
    Integer addCuocHop(CuocHopDtoRequest cuocHopDtoRequest);
    Integer updateCuocHop(CuocHopDtoRequest cuocHopDtoRequest);
    Integer deleteCuocHop(String maCuocHop);
    CuocHopDtoResponse getCuocHop(String maCuocHop);
    String getMaCuocHop(CuocHopDtoRequest cuocHopDtoRequest);
}
