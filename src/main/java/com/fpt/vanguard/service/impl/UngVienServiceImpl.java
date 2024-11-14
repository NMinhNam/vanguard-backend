package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.UngVienDtoRequest;
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

    @Override
    public int saveUngVien(UngVienDtoRequest ungVienDtoRequest) {
        System.out.println(ungVienMapper.isExistUngVien(ungVienDtoRequest.getMaUngVien()));
        if (ungVienMapper.isExistUngVien(ungVienDtoRequest.getMaUngVien()))
            return updateUngVien(ungVienDtoRequest);
        return insertUngVien(ungVienDtoRequest);
    }

    @Override
    public int insertUngVien(UngVienDtoRequest ungVienDtoRequest) {
        String maUngVien = ungVienDtoRequest.getMaUngVien();
        Boolean isExitsUngVien = ungVienMapper.isExistUngVien(maUngVien);
        if(isExitsUngVien)
            throw new AppException(ErrorCode.NHAN_VIEN_EXISTED);
        return ungVienMapper.insertUngVien(ungVienMapstruct.toUngVien(ungVienDtoRequest));
    }

    @Override
    public int updateUngVien(UngVienDtoRequest ungVienDtoRequest) {
        String maUngVien = ungVienDtoRequest.getMaUngVien();
        Boolean isExitsUngVien = ungVienMapper.isExistUngVien(maUngVien);
        if(!isExitsUngVien)
            throw new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST);
        return ungVienMapper.updateUngVien(ungVienMapstruct.toUngVien(ungVienDtoRequest));
    }
}
