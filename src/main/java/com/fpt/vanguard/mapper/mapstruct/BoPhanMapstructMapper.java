package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.BoPhanDtoRequest;
import com.fpt.vanguard.dto.response.BoPhanDtoResponse;
import com.fpt.vanguard.entity.BoPhan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BoPhanMapstructMapper {
    BoPhan toBoPhan(BoPhanDtoRequest boPhan);

    @Mapping(source = "maBoPhan", target = "boPhan")
    BoPhanDtoResponse toBoPhanDtoResponse(BoPhan boPhan);
}
