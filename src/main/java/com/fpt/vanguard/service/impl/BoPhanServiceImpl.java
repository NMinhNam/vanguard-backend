package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.BoPhanDtoRequest;
import com.fpt.vanguard.dto.response.BoPhanDtoResponse;
import com.fpt.vanguard.entity.BoPhan;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.exception.ErrorCode;
import com.fpt.vanguard.mapper.mapstruct.BoPhanMapstruct;
import com.fpt.vanguard.mapper.mybatis.BoPhanMapper;
import com.fpt.vanguard.service.BoPhanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoPhanServiceImpl implements BoPhanService {
    private final BoPhanMapstruct boPhanMapstructMapper;
    private final BoPhanMapper boPhanMybatisMapper;

    @Override
    public List<BoPhanDtoResponse> getAllBoPhan() {
        List<BoPhanDtoResponse> listResultEntity = boPhanMybatisMapper.getAllBoPhan()
                .stream()
                .map(boPhanMapstructMapper::toBoPhanDtoResponse)
                .toList();
        if(listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_BO_PHAN_EMPTY);
        return listResultEntity;
    }

    @Override
    public BoPhanDtoResponse findBoPhanByMaBoPhan(String maBoPhan) {
        BoPhanDtoResponse resultEntity = boPhanMapstructMapper.toBoPhanDtoResponse(
                boPhanMybatisMapper.findById(maBoPhan)
        );
        if(!Objects.nonNull(resultEntity)) throw new AppException(ErrorCode.BO_PHAN_NOT_EXIST);
        return resultEntity;
    }

    @Override
    public int saveBoPhan(BoPhanDtoRequest boPhan) {
        if(boPhanMybatisMapper.isExist(boPhan.getBoPhan())){
            return boPhanMybatisMapper.updateBoPhan(boPhan);
        }else {
            return boPhanMybatisMapper.insertBoPhan(boPhan);
        }
    }

    @Override
    public int deleteBoPhan(String maBoPhan) {
        if (!boPhanMybatisMapper.isExist(maBoPhan)) throw new AppException(ErrorCode.BO_PHAN_NOT_EXIST);
        return boPhanMybatisMapper.deleteBoPhan(maBoPhan);
    }
}
