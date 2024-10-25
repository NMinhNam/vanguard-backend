package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.PheDuyetDtoRequest;
import com.fpt.vanguard.dto.response.PheDuyetDtoResponse;
import com.fpt.vanguard.entity.PheDuyet;
import jakarta.mail.MessagingException;

import java.util.List;

public interface PheDuyetService {
    List<PheDuyetDtoResponse> getPheDuyets(String maNhanVien);
    Integer createPheDuyet(PheDuyetDtoRequest request) throws MessagingException;
    Integer updatePheDuyet(PheDuyetDtoRequest request) throws MessagingException;
    Integer deletePheDuyet(String maDon);
}
