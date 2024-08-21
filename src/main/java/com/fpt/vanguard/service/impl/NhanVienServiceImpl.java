package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.entity.NhanVien;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.mapper.NhanVienMapper;
import com.fpt.vanguard.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienMapper nhanVienMapper;

    @Override
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> listResultEntity = nhanVienMapper.findAll();
        if (listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_NHAN_VIEN_EMPTY);
        return listResultEntity;
    }

    @Override
    public Optional<NhanVien> getNhanVienById(Integer id) {
        return Optional.ofNullable(nhanVienMapper.findById(id).orElseThrow(() -> new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST)));
    }
}
