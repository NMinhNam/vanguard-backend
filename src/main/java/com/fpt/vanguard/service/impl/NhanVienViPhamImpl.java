package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.NhanVienViPhamDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienViPhamDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.NhanVienViPhamMapstruct;
import com.fpt.vanguard.mapper.mybatis.NhanVienMapper;
import com.fpt.vanguard.mapper.mybatis.NhanVienViPhamMapper;
import com.fpt.vanguard.mapper.mybatis.ViPhamMapper;
import com.fpt.vanguard.service.NhanVienService;
import com.fpt.vanguard.service.NhanVienViPhamService;
import com.fpt.vanguard.service.ViPhamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class NhanVienViPhamImpl implements NhanVienViPhamService {
    private final NhanVienViPhamMapper nhanVienViPhamMapper;
    private final NhanVienViPhamMapstruct nhanVienViPhamMapstruct;
    private final NhanVienMapper nhanVienMapper;
    private final ViPhamMapper viPhamMapper;

    @Override
    public List<NhanVienViPhamDtoResponse> getAllNhanVienViPham() {
        List<NhanVienViPhamDtoResponse> responses = nhanVienViPhamMapstruct
                .toListNhanVienViPhamDtoResponse(
                nhanVienViPhamMapper.getAll());
        if(!Objects.nonNull(responses))
            throw new AppException(ErrorCode.NHAN_VIEN_VI_PHAM_NOT_EXIST);
        return responses;
    }

    @Override
    public List<NhanVienViPhamDtoResponse> getNhanVienViPhamByNhanVienId(String maNhanVien) {
        List<NhanVienViPhamDtoResponse> responses = nhanVienViPhamMapstruct
                .toListNhanVienViPhamDtoResponse(
                        nhanVienViPhamMapper.getNhanVienViPhams(maNhanVien));
        if(!Objects.nonNull(responses))
            throw new AppException(ErrorCode.NHAN_VIEN_VI_PHAM_NOT_EXIST);
        return responses;
    }

    @Override
    public Integer insertNhanVienViPham(NhanVienViPhamDtoRequest nhanVienViPhamDtoRequest) {
        String maNhanVien = nhanVienViPhamDtoRequest.getMaNhanVien();
        String maViPham = nhanVienViPhamDtoRequest.getMaViPham();
        Boolean isExitsNhanVien = nhanVienMapper.existsById(maNhanVien);
        Boolean isExitsViPham = viPhamMapper.isViPhamExist(maViPham);
        if (!isExitsNhanVien)
            throw new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST);
        if (!isExitsViPham)
            throw new AppException(ErrorCode.VI_PHAM_NOT_EXIST);
        return nhanVienViPhamMapper.insertNhanVienViPham(
                nhanVienViPhamMapstruct
                        .toNhanVienViPham(nhanVienViPhamDtoRequest));
    }
}
