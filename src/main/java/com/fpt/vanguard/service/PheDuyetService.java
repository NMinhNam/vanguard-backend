package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.PheDuyetDtoRequest;
import com.fpt.vanguard.dto.response.PheDuyetDtoResponse;
import jakarta.mail.MessagingException;

import java.text.ParseException;
import java.util.List;

public interface PheDuyetService {
    List<PheDuyetDtoResponse> getPheDuyets(String maNhanVien);
    Integer createPheDuyet(PheDuyetDtoRequest request) throws MessagingException;
    Integer updatePheDuyet(PheDuyetDtoRequest request) throws MessagingException, ParseException;
    Integer deletePheDuyet(String maDon);
    List<PheDuyetDtoResponse> getPheDuyetDetail(String maDon);
}
