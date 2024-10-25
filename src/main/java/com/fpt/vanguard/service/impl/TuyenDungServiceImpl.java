package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.TuyenDungDtoRequest;
import com.fpt.vanguard.dto.response.TuyenDungDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.TuyenDungMapstruct;
import com.fpt.vanguard.mapper.mybatis.TuyenDungMapper;
import com.fpt.vanguard.service.TuyenDungService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TuyenDungServiceImpl implements TuyenDungService {
    private final TuyenDungMapstruct tuyenDungMapstructMapper;
    private final TuyenDungMapper tuyenDungMapper;

    @Override
    public List<TuyenDungDtoResponse> getAllTuyenDung() {
        List<TuyenDungDtoResponse> listResultEntity = tuyenDungMapper.getAllTuyenDung()
                .stream()
                .map(tuyenDungMapstructMapper::toTuyenDungDtoResponse)
                .toList();
        if(listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_PHONG_BAN_EMPTY);
        return listResultEntity;
    }

    @Override
    public TuyenDungDtoResponse getTuyenDungById(String maTuyenDung) {
        TuyenDungDtoResponse resultEntity = tuyenDungMapstructMapper.toTuyenDungDtoResponse(
                tuyenDungMapper.getTuyenDungById(maTuyenDung)
        );
        if(!Objects.nonNull(resultEntity)) throw new AppException(ErrorCode.PHONG_BAN_NOT_EXIST);
        return resultEntity;
    }

    @Override
    public int saveTuyenDung(TuyenDungDtoRequest tuyenDung) {
        // Log thông tin của tuyenDung
        System.out.println("TuyenDung Info: " + tuyenDung);

        // Kiểm tra xem bản ghi đã tồn tại hay chưa
        if (tuyenDungMapper.isExist(tuyenDung.getMaTuyenDung())) {
            System.out.println("Record already exists. Skipping insert.");
            return 0; // Bản ghi đã tồn tại
        } else {
            int result = tuyenDungMapper.insertTuyenDung(tuyenDung);
            System.out.println("Insert result: " + result);
            return result;
        }
    }
}
