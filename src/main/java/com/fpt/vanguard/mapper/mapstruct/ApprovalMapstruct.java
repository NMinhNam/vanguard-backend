package com.fpt.vanguard.mapper.mapstruct;

import com.fpt.vanguard.dto.request.ApprovalDetailsDtoRequest;
import com.fpt.vanguard.dto.response.ApprovalDetailsDtoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApprovalMapstruct {
    ApprovalDetailsDtoRequest toApprovalDetailsDtoRequest(ApprovalDetailsDtoResponse request);
}
