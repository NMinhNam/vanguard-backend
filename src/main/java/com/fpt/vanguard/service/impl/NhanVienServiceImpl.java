package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.entity.NhanVien;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.mapper.mapstruct.NhanVienMapstructMapper;
import com.fpt.vanguard.mapper.mybatis.NhanVienMybatisMapper;
import com.fpt.vanguard.service.NhanVienService;
import com.fpt.vanguard.util.FormatDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienMybatisMapper nhanVienMybatisMapper;
    private final NhanVienMapstructMapper nhanVienMapstructMapper;

    @Override
    public List<NhanVienDtoResponse> getAllNhanVien() {
        List<NhanVienDtoResponse> listResultEntity = nhanVienMybatisMapper.findAll()
                .stream()
                .map(nhanVienMapstructMapper::toNhanVienDtoResponse)
                .toList();
        if (listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_NHAN_VIEN_EMPTY);
        return listResultEntity;
    }

    @Override
    public NhanVienDtoResponse getNhanVienById(String id) {
        return nhanVienMapstructMapper.toNhanVienDtoResponse(Optional.ofNullable(nhanVienMybatisMapper.findById(id)).orElseThrow(() -> new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST)));
    }
    
    @Override
    public NhanVienDtoResponse getNhanVien(NhanVienDtoRequest nhanVienDtoRequest) {
        String ngaySinhFormatted = FormatDate.formatDateStringToStringFormat(nhanVienDtoRequest.getNgaySinh(), "dd/MM/yyyy", "yyyy-MM-dd");
        nhanVienDtoRequest.setNgaySinh(ngaySinhFormatted);
        NhanVien nhanVien = nhanVienMybatisMapper.findNhanVien(nhanVienMapstructMapper.toNhanVien(nhanVienDtoRequest));
        return nhanVienMapstructMapper.toNhanVienDtoResponse(nhanVien);
    }

    @Override
    public Integer saveNhanVien(NhanVienDtoRequest nhanVienDtoRequest) {
        if (nhanVienMybatisMapper.existsById(nhanVienDtoRequest.getMaNhanVien())) {
            return nhanVienMybatisMapper.updateNhanVien(nhanVienMapstructMapper.toNhanVien(nhanVienDtoRequest));
        } else {
            return nhanVienMybatisMapper.insertNhanVien(nhanVienMapstructMapper.toNhanVien(nhanVienDtoRequest));
        }
    }
}
