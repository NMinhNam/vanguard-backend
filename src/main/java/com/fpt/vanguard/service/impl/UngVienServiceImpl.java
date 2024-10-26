package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.response.UngVienDtoResponse;
import com.fpt.vanguard.entity.UngVien;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.UngVienMapstruct;
import com.fpt.vanguard.mapper.mybatis.UngVienMapper;
import com.fpt.vanguard.service.UngVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UngVienServiceImpl implements UngVienService {
    private final UngVienMapper ungVienMapper;
    private final UngVienMapstruct ungVienMapstruct;

    @Override
    public List<UngVienDtoResponse> getUngVien(String tenViTri) {
        List<UngVien> responseList = ungVienMapper.findAll(tenViTri);
        if (responseList.isEmpty()) throw new AppException(ErrorCode.LIST_UNG_VIEN_EMPTY);

        return ungVienMapstruct.toUngVienDtoResponseList(responseList);
    }
}
