package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.NgayLeDtoRequest;
import com.fpt.vanguard.dto.response.NgayLeDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.NgayLeMapstruct;
import com.fpt.vanguard.mapper.mybatis.NgayLeMapper;
import com.fpt.vanguard.service.NgayLeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NgayLeServiceImpl implements NgayLeService {
    private final NgayLeMapper ngayLeMapper;
    private final NgayLeMapstruct ngayLeMapstruct;

    @Override
    public List<NgayLeDtoResponse> getAllNgayLe() {
        return ngayLeMapstruct.toDtoList(ngayLeMapper.getAllNgayLes());
    }

    @Override
    public Integer saveNgayLe(NgayLeDtoRequest ngayLeDtoRequest) {
        String tenNgayLe = ngayLeDtoRequest.getTenNgayLe();
        Boolean isNgayLeExist = ngayLeMapper.isNgayLeExist(tenNgayLe);
        if (isNgayLeExist) {
            return ngayLeMapper.updateNgayLe(ngayLeMapstruct.toNgayLe(ngayLeDtoRequest));
        }

        return ngayLeMapper.insertNgayLe(ngayLeMapstruct.toNgayLe(ngayLeDtoRequest));
    }

    @Override
    public Integer deleteNgayLe(String tenNgayLe) {
        return ngayLeMapper.deleteNgayLe(tenNgayLe);
    }
}
