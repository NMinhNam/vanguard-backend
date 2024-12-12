package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.PhuCapDtoRequest;
import com.fpt.vanguard.dto.response.PhuCapDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.PhuCapMapstruct;
import com.fpt.vanguard.mapper.mybatis.NhanVienPhuCapMapper;
import com.fpt.vanguard.mapper.mybatis.PhuCapMapper;
import com.fpt.vanguard.service.NhanVienPhuCapService;
import com.fpt.vanguard.service.PhuCapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NhanVienPhuCapImpl implements NhanVienPhuCapService {
    private final PhuCapService phuCapService;
    private final PhuCapMapstruct phuCapMapstruct;
    private final NhanVienPhuCapMapper nhanVienPhuCapMapper;
    private final PhuCapMapper phuCapMapper;

    @Override
    public Integer insertNhanVienPhuCap(PhuCapDtoRequest phuCapDtoRequest) {
        PhuCapDtoResponse nhanVienPhuCap = phuCapService.getNhanVienPhuCap(phuCapDtoRequest);
        if(!Objects.nonNull(nhanVienPhuCap))
            throw new AppException(ErrorCode.NHAN_VIEN_PHU_CAP_EXISTED);
        return nhanVienPhuCapMapper.insertNhanVienPhuCap(phuCapMapstruct.toPhuCap(phuCapDtoRequest));
    }

    @Override
    public Integer deteleNhanVienPhuCap(PhuCapDtoRequest phuCapDtoRequest) {
        PhuCapDtoResponse NhanVienPhuCap = phuCapService.getNhanVienPhuCap(phuCapDtoRequest);
        if(Objects.nonNull(NhanVienPhuCap)){
            throw new AppException(ErrorCode.NHAN_VIEN_PHU_CAP_NOT_EXIST);
        }
        return nhanVienPhuCapMapper.deleteNhanVienPhuCap(phuCapMapstruct.toPhuCap(phuCapDtoRequest));
    }

}
