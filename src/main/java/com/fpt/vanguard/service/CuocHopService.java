package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.dto.response.CuocHopDtoResponse;
import jakarta.mail.MessagingException;

import java.util.List;

public interface CuocHopService {
    List<CuocHopDtoResponse> getAllCuocHops();
    List<CuocHopDtoResponse> getCuocHopsByMaNhanVien(String maNhanVien);
    Integer addCuocHop(CuocHopDtoRequest cuocHopDtoRequest);
    Integer updateCuocHop(CuocHopDtoRequest cuocHopDtoRequest) throws MessagingException;
    Integer deleteCuocHop(String maCuocHop) throws MessagingException;
    CuocHopDtoResponse getCuocHop(String maCuocHop);
    CuocHopDtoResponse getMaCuocHop(CuocHopDtoRequest cuocHopDtoRequest);
}
