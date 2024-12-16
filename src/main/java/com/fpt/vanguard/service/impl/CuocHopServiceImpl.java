package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.response.CuocHopDtoResponse;
import com.fpt.vanguard.entity.CuocHop;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.CuocHopMapstruct;
import com.fpt.vanguard.mapper.mybatis.CuocHopMapper;
import com.fpt.vanguard.service.CuocHopService;
import com.fpt.vanguard.service.MailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CuocHopServiceImpl implements CuocHopService {
    private final CuocHopMapper cuocHopMapper;
    private final CuocHopMapstruct cuocHopMapstruct;
    private final MailService mailService;

    @Override
    public List<CuocHopDtoResponse> getAllCuocHops() {
        return cuocHopMapstruct.toDtoList(cuocHopMapper.getAllCuocHops());
    }

    @Override
    public List<CuocHopDtoResponse> getCuocHopsByMaNhanVien(String maNhanVien) {
        return cuocHopMapstruct.toDtoList(cuocHopMapper.getCuocHopByMaNhanVien(maNhanVien));
    }

    @Override
    public Integer addCuocHop(CuocHopDtoRequest cuocHopDtoRequest) {
        String maCuocHop = cuocHopDtoRequest.getMaCuocHop();
        Boolean isCuocHopExist = cuocHopMapper.isCuocHopExist(maCuocHop);
        if (isCuocHopExist) throw new AppException(ErrorCode.MEETING_EXISTED);
        return cuocHopMapper.insertCuocHop(cuocHopMapstruct.toCuocHop(cuocHopDtoRequest));
    }

    @Override
    public Integer updateCuocHop(CuocHopDtoRequest cuocHopDtoRequest) throws MessagingException {
        String maCuocHop = cuocHopDtoRequest.getMaCuocHop();
        Boolean isCuocHopExist = cuocHopMapper.isCuocHopExist(maCuocHop);
        if (!isCuocHopExist) throw new AppException(ErrorCode.MEETING_NOT_EXISTED);

        List<CuocHop> cuocHopList = cuocHopMapper.getInfoNhanVienFromCuocHop(maCuocHop);

        for (CuocHop cuocHop : cuocHopList) {
            String tenNhanVien = cuocHop.getTenNhanVien();
            String email = cuocHop.getEmailNhanVien();

            cuocHopDtoRequest.setTenNhanVien(tenNhanVien);
            cuocHopDtoRequest.setEmailNhanVien(email);

            sendUpdatedMeetingNotification(cuocHopDtoRequest);
        }

        return cuocHopMapper.updateCuocHop(cuocHopMapstruct.toCuocHop(cuocHopDtoRequest));
    }

    private void sendUpdatedMeetingNotification(CuocHopDtoRequest cuocHopDtoRequest) throws MessagingException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("tenNhanVien", cuocHopDtoRequest.getTenNhanVien());
        variables.put("tenCuocHop", cuocHopDtoRequest.getTenCuocHop());
        variables.put("thoiGianBatDau", cuocHopDtoRequest.getThoiGianBatDau());
        variables.put("thoiGianKetThuc", cuocHopDtoRequest.getThoiGianKetThuc());
        variables.put("viTri", cuocHopDtoRequest.getViTri());
        variables.put("videoCallUrl", cuocHopDtoRequest.getVideoCallUrl());
        variables.put("nguoiToChuc", cuocHopDtoRequest.getTenNguoiToChuc());
        variables.put("ghiChu", cuocHopDtoRequest.getGhiChu());
        variables.put("updateMessage", "The meeting details have been updated.");

        MailDtoRequest mailDtoRequest = MailDtoRequest.builder()
                .to(cuocHopDtoRequest.getEmailNhanVien())
                .subject("Updated Meeting Notification: " + cuocHopDtoRequest.getTenCuocHop())
                .templateName("meeting-updated-notification.html")
                .variables(variables)
                .build();

        mailService.sendMail(mailDtoRequest);
    }

    @Override
    public Integer deleteCuocHop(String maCuocHop) throws MessagingException {
        List<CuocHop> cuocHopList = cuocHopMapper.getInfoNhanVienFromCuocHop(maCuocHop);

        for (CuocHop cuocHop : cuocHopList) {
            String tenNhanVien = cuocHop.getTenNhanVien();
            String email = cuocHop.getEmailNhanVien();
            String tenCuocHop = cuocHop.getTenCuocHop();

            sendCancelledMeetingNotification(
            CuocHopDtoRequest.builder()
                    .tenNhanVien(tenNhanVien)
                    .emailNhanVien(email)
                    .tenCuocHop(tenCuocHop)
                    .build()
            );
        }

        return cuocHopMapper.deleteCuocHop(maCuocHop);
    }

    private void sendCancelledMeetingNotification(CuocHopDtoRequest cuocHopDtoRequest) throws MessagingException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("tenNhanVien", cuocHopDtoRequest.getTenNhanVien());
        variables.put("tenCuocHop", cuocHopDtoRequest.getTenCuocHop());
        variables.put("cancelMessage", "The meeting has been cancelled.");

        MailDtoRequest mailDtoRequest = MailDtoRequest.builder()
                .to(cuocHopDtoRequest.getEmailNhanVien())
                .subject("Cancelled Meeting Notification: " + cuocHopDtoRequest.getTenCuocHop())
                .templateName("meeting-cancelled-notification.html")
                .variables(variables)
                .build();

        mailService.sendMail(mailDtoRequest);
    }

    @Override
    public CuocHopDtoResponse getCuocHop(String maCuocHop) {
        return cuocHopMapstruct.toDtoResponse(Optional.ofNullable(cuocHopMapper.getCuocHop(maCuocHop)).orElseThrow(() -> new AppException(ErrorCode.CUOC_HOP_NOT_EXIST)));
    }

    @Override
    public CuocHopDtoResponse getMaCuocHop(CuocHopDtoRequest cuocHopDtoRequest) {
        return cuocHopMapstruct.toDtoResponse(cuocHopMapper.getMaCuocHop(cuocHopMapstruct.toCuocHop(cuocHopDtoRequest)));
    }
}
