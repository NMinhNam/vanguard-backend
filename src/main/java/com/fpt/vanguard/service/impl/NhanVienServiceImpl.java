package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.entity.NhanVien;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.mapper.mapstruct.NhanVienMapstruct;
import com.fpt.vanguard.mapper.mybatis.NhanVienMapper;
import com.fpt.vanguard.service.MailService;
import com.fpt.vanguard.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienMapper nhanVienMapper;
    private final NhanVienMapstruct nhanVienMapstruct;
    private final MailService mailService;

    @Override
    public List<NhanVienDtoResponse> getAllNhanVien() {
        var listEntity = nhanVienMapper.findAll();
        List<NhanVienDtoResponse> listResultEntity =
                nhanVienMapstruct.toNhanVienDtoResponseList(listEntity);
        if (listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_NHAN_VIEN_EMPTY);
        return listResultEntity;
    }

    @Override
    public NhanVienDtoResponse getNhanVienById(String id) {
        return nhanVienMapstruct.toNhanVienDtoResponse(
                Optional.ofNullable(nhanVienMapper.findById(id))
                        .orElseThrow(() -> new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST)
                        )
        );
    }
    
    @Override
    public NhanVienDtoResponse getNhanVien(NhanVienDtoRequest nhanVienDtoRequest) {
        NhanVien nhanVien = nhanVienMapper.findNhanVien(
                nhanVienMapstruct.toNhanVien(nhanVienDtoRequest)
        );
        return nhanVienMapstruct.toNhanVienDtoResponse(nhanVien);
    }

    @Override
    public Integer saveNhanVien(NhanVienDtoRequest nhanVienDtoRequest) {
        if (nhanVienMapper.existsById(nhanVienDtoRequest.getMaNhanVien())) {
            return nhanVienMapper.updateNhanVien(
                    nhanVienMapstruct.toNhanVien(nhanVienDtoRequest)
            );
        } else {
            return nhanVienMapper.insertNhanVien(
                    nhanVienMapstruct.toNhanVien(nhanVienDtoRequest)
            );
        }
    }

    @Override
    public Integer deleteNhanVien(String id) {
        return 0;
    }
}
