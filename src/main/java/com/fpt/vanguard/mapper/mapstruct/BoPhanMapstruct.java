package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.BoPhanDtoRequest;
import com.fpt.vanguard.dto.response.BoPhanDtoResponse;
import com.fpt.vanguard.entity.BoPhan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoPhanMapstruct {
    BoPhan toBoPhan(BoPhanDtoRequest boPhan);

    BoPhanDtoResponse toBoPhanDtoResponse(BoPhan boPhan);

    List<BoPhanDtoResponse> toBoPhanDtoResponseList(List<BoPhan> boPhanList);
}
