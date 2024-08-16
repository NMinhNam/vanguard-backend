package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.entity.NhanVien;
import com.fpt.vanguard.mapper.NhanVienMapper;
import com.fpt.vanguard.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienMapper nhanVienMapper;

    @Override
    public List<NhanVien> getAllNhanVien() {
        var listResultEntity = nhanVienMapper.findAll();
        return Objects.nonNull(listResultEntity) ? listResultEntity : Collections.emptyList();
    }
}
