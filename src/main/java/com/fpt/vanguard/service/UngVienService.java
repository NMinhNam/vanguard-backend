package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.UngVienDtoRequest;
import com.fpt.vanguard.dto.response.UngVienDtoResponse;
import jakarta.mail.MessagingException;

import java.text.ParseException;
import java.util.List;

public interface UngVienService {
    List<UngVienDtoResponse> getUngVien(String tenViTri);

    int saveUngVien(UngVienDtoRequest ungVienDtoRequest) throws MessagingException, ParseException;

    int insertUngVien(UngVienDtoRequest ungVienDtoRequest);

    int updateUngVien(UngVienDtoRequest ungVienDtoRequest) throws MessagingException, ParseException;

    UngVienDtoResponse getUngVienByMaUngVien(String maUngVien);

    int deleteUngVien(String maUngVien);

    List<UngVienDtoResponse> getUngVienByViTriAndTrangThai(String maViTri, int trangThai) throws MessagingException, ParseException;

}
