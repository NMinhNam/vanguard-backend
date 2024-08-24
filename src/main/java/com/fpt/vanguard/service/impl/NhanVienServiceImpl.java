package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.mapper.mapstruct.NhanVienMapstructMapper;
import com.fpt.vanguard.mapper.mybatis.NhanVienMybatisMapper;
import com.fpt.vanguard.service.NhanVienService;
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
        return nhanVienMapstructMapper.toNhanVienDtoResponse(
                Optional.ofNullable(nhanVienMybatisMapper.findById(id))
                        .orElseThrow(() -> new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST))
        );
    }

    @Override
    public NhanVienDtoResponse getNhanVien(NhanVienDtoRequest nhanVienDtoRequest) {
        System.out.println(nhanVienDtoRequest.getMaNhanVien());
        System.out.println(nhanVienDtoRequest.getHoTen());
        System.out.println(nhanVienDtoRequest.getGioiTinh());
        System.out.println(nhanVienDtoRequest.getNgaySinh());
        System.out.println(nhanVienDtoRequest.getDienThoai());
        System.out.println(nhanVienDtoRequest.getCccd());
        System.out.println(nhanVienDtoRequest.getDiaChi());
        System.out.println(nhanVienDtoRequest.getMaPhongBan());
        System.out.println(nhanVienDtoRequest.getMaChucVu());
        System.out.println(nhanVienDtoRequest.getMaBoPhan());
        System.out.println(nhanVienDtoRequest.getMaTrinhDo());
        return nhanVienMapstructMapper.toNhanVienDtoResponse(
                nhanVienMybatisMapper.findNhanVien(nhanVienDtoRequest)
        );
    }

    @Override
    public NhanVienDtoResponse saveNhanVien(NhanVienDtoRequest nhanVienDtoRequest) {
        if (nhanVienMybatisMapper.existsById(nhanVienDtoRequest.getMaNhanVien())) {
            return nhanVienMapstructMapper.toNhanVienDtoResponse(
                    nhanVienMybatisMapper.insertNhanVien(nhanVienDtoRequest)
            );
        } else {
            return nhanVienMapstructMapper.toNhanVienDtoResponse(
                    nhanVienMybatisMapper.updateNhanVien(nhanVienDtoRequest)
            );
        }
    }
}
