package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import jakarta.mail.MessagingException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface NhanVienService {
    List<NhanVienDtoResponse> getAllNhanVien();

    NhanVienDtoResponse getNhanVienById(String id);

    NhanVienDtoResponse getNhanVien(NhanVienDtoRequest nhanVienDtoRequest) throws ParseException;

    Integer createNhanVien(NhanVienDtoRequest nhanVienDtoRequest) throws MessagingException, ParseException;

    Integer updateNhanVien(NhanVienDtoRequest nhanVienDtoRequest) throws IOException;

    Integer deleteNhanVien(String id);

    NhanVienDtoResponse getNhanVienByUserName(String username);

    Integer createNhanVienByExcel(List<NhanVienDtoRequest> nhanVienDtoRequestList);
}
