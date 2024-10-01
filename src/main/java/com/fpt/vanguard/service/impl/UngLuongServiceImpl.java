package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.UngLuongDtoRequest;
import com.fpt.vanguard.dto.response.UngLuongDtoResponse;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.mapper.mapstruct.UngLuongMapstructMapper;
import com.fpt.vanguard.mapper.mybatis.UngLuongMybatisMapper;
import com.fpt.vanguard.service.UngLuongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UngLuongServiceImpl implements UngLuongService {
    private final UngLuongMybatisMapper ungLuongMybatisMapper;
    private final UngLuongMapstructMapper ungLuongMapstructMapper;

    @Override
    public List<UngLuongDtoResponse> getAllUngLuong() {
        List<UngLuongDtoResponse> listResultEntity = ungLuongMybatisMapper.findAll()
                .stream()
                .map(ungLuongMapstructMapper::toUngLuongDtoResponse)
                .toList();
        if (listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_UNG_LUONG_EMPTY);
        return listResultEntity;
    }

    @Override
    public UngLuongDtoResponse getUngLuongById(String id) {
        return ungLuongMapstructMapper.toUngLuongDtoResponse(
                Optional.ofNullable(ungLuongMybatisMapper.findById(id))
                        .orElseThrow(() -> new AppException(ErrorCode.UNG_LUONG_NOT_EXIST))
        );
    }

    @Override
    public UngLuongDtoResponse getUngLuong(UngLuongDtoRequest ungLuongDtoRequest) {
        System.out.println(ungLuongDtoRequest.getMaUngLuong());
        System.out.println(ungLuongDtoRequest.getNam());
        System.out.println(ungLuongDtoRequest.getThang());
        System.out.println(ungLuongDtoRequest.getNgay());
        System.out.println(ungLuongDtoRequest.getSoTien());
        System.out.println(ungLuongDtoRequest.getTrangThai());
        System.out.println(ungLuongDtoRequest.getMaNhanVien());
        return ungLuongMapstructMapper.toUngLuongDtoResponse(
                ungLuongMybatisMapper.findUngLuong(ungLuongDtoRequest)
        );
    }

    @Override
    public int saveUngLuong(UngLuongDtoRequest ungLuongDtoRequest) {
        if(ungLuongMybatisMapper.existsById(ungLuongDtoRequest.getMaUngLuong())){
            return ungLuongMybatisMapper.updateUngLuong(ungLuongDtoRequest);
        }else {
            return ungLuongMybatisMapper.insertUngLuong(ungLuongDtoRequest);
        }
    }

    @Override
    public int deleteUngLuong(String maUngLuong) {
        if (!ungLuongMybatisMapper.existsById(maUngLuong)) throw new AppException(ErrorCode.UNG_LUONG_NOT_EXIST);
        return ungLuongMybatisMapper.deleteUngLuong(maUngLuong);
    }
}
