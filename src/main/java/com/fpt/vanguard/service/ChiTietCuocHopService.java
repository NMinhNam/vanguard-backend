package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import jakarta.mail.MessagingException;

public interface ChiTietCuocHopService {
    Integer addNhanVienToCuocHop(CuocHopDtoRequest request) throws MessagingException;
}
