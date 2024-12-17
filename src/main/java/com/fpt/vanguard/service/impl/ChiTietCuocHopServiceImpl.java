package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.CuocHopDtoRequest;
import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.mapper.mapstruct.ChiTietCuocHopMapstruct;
import com.fpt.vanguard.mapper.mybatis.ChiTietCuocHopMapper;
import com.fpt.vanguard.service.ChiTietCuocHopService;
import com.fpt.vanguard.service.CuocHopService;
import com.fpt.vanguard.service.MailService;
import com.fpt.vanguard.service.NhanVienService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChiTietCuocHopServiceImpl implements ChiTietCuocHopService {
    private final ChiTietCuocHopMapper cuocHopMapper;
    private final ChiTietCuocHopMapstruct cuocHopMapstruct;
    private final CuocHopService cuocHopService;
    private final MailService mailService;
    private final NhanVienService nhanVienService;

    @Override
    public Integer addNhanVienToCuocHop(CuocHopDtoRequest request) throws MessagingException {
        String maCuocHop = cuocHopService.getMaCuocHop(request).getMaCuocHop();
        request.setMaCuocHop(maCuocHop);
        Integer addResponse = cuocHopMapper.insertChiTietCuocHop(cuocHopMapstruct.toChiTietCuocHop(request));

        String maNhanVien = request.getMaNhanVien();
        NhanVienDtoResponse nhanVienDtoResponse = nhanVienService.getNhanVienById(maNhanVien);
        String tenNhanVien = nhanVienDtoResponse.getHoTen();
        String emailNhanVien = nhanVienDtoResponse.getEmail();

        String maNguoiToChuc = request.getNguoiToChuc();
        String tenNguoiToChuc = nhanVienService.getNhanVienById(maNguoiToChuc).getHoTen();

        request.setTenNhanVien(tenNhanVien);
        request.setEmailNhanVien(emailNhanVien);
        request.setTenNguoiToChuc(tenNguoiToChuc);

        sendMeetingNotification(request);
        return addResponse;
    }

    public void sendMeetingNotification(CuocHopDtoRequest cuocHopDtoRequest) throws MessagingException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("tenNhanVien", cuocHopDtoRequest.getTenNhanVien());
        variables.put("tenCuocHop", cuocHopDtoRequest.getTenCuocHop());
        variables.put("thoiGianBatDau", cuocHopDtoRequest.getThoiGianBatDau());
        variables.put("thoiGianKetThuc", cuocHopDtoRequest.getThoiGianKetThuc());
        variables.put("viTri", cuocHopDtoRequest.getViTri());
        variables.put("videoCallUrl", cuocHopDtoRequest.getVideoCallUrl());
        variables.put("nguoiToChuc", cuocHopDtoRequest.getTenNguoiToChuc());
        variables.put("ghiChu", cuocHopDtoRequest.getGhiChu());

        MailDtoRequest mailDtoRequest = MailDtoRequest.builder()
                .to(cuocHopDtoRequest.getEmailNhanVien())
                .subject("Meeting Notification: " + cuocHopDtoRequest.getTenCuocHop())
                .templateName("meeting-invitation.html")
                .variables(variables)
                .build();

        mailService.sendMail(mailDtoRequest);
    }
}
