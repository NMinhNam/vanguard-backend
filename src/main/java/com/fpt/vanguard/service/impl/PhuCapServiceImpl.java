package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.PhuCapDtoRequest;
import com.fpt.vanguard.dto.response.PhuCapDtoResponse;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.PhuCapMapstruct;
import com.fpt.vanguard.mapper.mybatis.PhuCapMapper;
import com.fpt.vanguard.service.PhuCapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhuCapServiceImpl implements PhuCapService {
    private final PhuCapMapper phuCapMapper;
    private final PhuCapMapstruct phuCapMapstruct;

    @Override
    public List<PhuCapDtoResponse> getAllPhuCaps() {
        return phuCapMapstruct.toListDtoResponses(
                phuCapMapper.getAllPhuCaps()
        );
    }

    @Override
    public Integer savePhuCap(PhuCapDtoRequest phuCapDtoRequest) {
        String maPhuCap = phuCapDtoRequest.getMaPhuCap();
        Boolean isExistPhuCap = phuCapMapper.isPhuCapExist(maPhuCap);
        if(isExistPhuCap){
            return updatePhuCap(phuCapDtoRequest);
        }
        return insertPhuCap(phuCapDtoRequest);
    }

    @Override
    public Integer deletePhuCap(String maPhuCap) {
        Boolean isExistPhuCap = phuCapMapper.isPhuCapExist(maPhuCap);
        if(!isExistPhuCap)
            throw new AppException(ErrorCode.PHU_CAP_NOT_EXISTED);
        return phuCapMapper.deletePhuCap(maPhuCap);
    }


    public Integer updatePhuCap(PhuCapDtoRequest phuCapDtoRequest){
        String maPhuCap = phuCapDtoRequest.getMaPhuCap();
        Boolean isExistPhuCap = phuCapMapper.isPhuCapExist(maPhuCap);
        if(!isExistPhuCap)
            throw new AppException(ErrorCode.PHU_CAP_NOT_EXISTED);
        return phuCapMapper.updatePhuCap(phuCapMapstruct.toPhuCap(phuCapDtoRequest));
    }

    public Integer insertPhuCap(PhuCapDtoRequest phuCapDtoRequest){
        String maPhuCap = phuCapDtoRequest.getMaPhuCap();
        Boolean isExistPhuCap = phuCapMapper.isPhuCapExist(maPhuCap);
        if(isExistPhuCap)
            throw new AppException(ErrorCode.PHU_CAP_EXISTED);
        return phuCapMapper.insertPhuCap(phuCapMapstruct.toPhuCap(phuCapDtoRequest));
    }
}
