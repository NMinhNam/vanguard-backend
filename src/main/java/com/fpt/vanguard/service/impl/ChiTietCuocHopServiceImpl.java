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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        List<String> danhSachNhanVienReq = request.getDanhSachMaNhanVien();
        List<String> danhSachNhanVienHienTai = cuocHopMapper.getDanhSachMaNhanVienByCuocHop(maCuocHop);

        if (danhSachNhanVienHienTai.size() == danhSachNhanVienReq.size() &&
                danhSachNhanVienHienTai.containsAll(danhSachNhanVienReq)) {
            return 0;
        }

        List<String> toAdd = getItemsToAdd(danhSachNhanVienHienTai, danhSachNhanVienReq);
        List<String> toRemove = getItemsToRemove(danhSachNhanVienHienTai, danhSachNhanVienReq);

        removeEmployeesFromMeeting(toRemove, maCuocHop);

        addEmployeesToMeeting(toAdd, maCuocHop);

        Integer addResponse = cuocHopMapper.insertChiTietCuocHop(cuocHopMapstruct.toChiTietCuocHop(request));

        sendMeetingNotifications(request, toAdd);

        return addResponse;
    }

    private void sendMeetingNotifications(CuocHopDtoRequest request, List<String> toAdd) throws MessagingException {
        for (String maNhanVien : toAdd) {
            if (!request.getDanhSachMaNhanVien().contains(maNhanVien)) {
                continue;
            }

            NhanVienDtoResponse nhanVienDtoResponse = nhanVienService.getNhanVienById(maNhanVien);
            String tenNhanVien = nhanVienDtoResponse.getHoTen();
            String emailNhanVien = nhanVienDtoResponse.getEmail();
            String maNguoiToChuc = request.getNguoiToChuc();
            String tenNguoiToChuc = nhanVienService.getNhanVienById(maNguoiToChuc).getHoTen();

            request.setTenNhanVien(tenNhanVien);
            request.setEmailNhanVien(emailNhanVien);
            request.setTenNguoiToChuc(tenNguoiToChuc);

            sendMeetingNotification(request);
        }
    }

    private List<String> getItemsToAdd(List<String> currentList, List<String> requestList) {
        return requestList.stream()
                .filter(id -> !currentList.contains(id))
                .collect(Collectors.toList());
    }

    private List<String> getItemsToRemove(List<String> currentList, List<String> requestList) {
        return currentList.stream()
                .filter(id -> !requestList.contains(id))
                .collect(Collectors.toList());
    }

    private void removeEmployeesFromMeeting(List<String> toRemove, String maCuocHop) {
        for (String maNhanVien : toRemove) {
            cuocHopMapper.deleteChiTietCuocHop(maCuocHop, maNhanVien);
        }
    }

    private void addEmployeesToMeeting(List<String> toAdd, String maCuocHop) {
        for (String maNhanVien : toAdd) {
            CuocHopDtoRequest newRecord = new CuocHopDtoRequest(maCuocHop, maNhanVien); // Tạo đối tượng mới với mã cuộc họp và mã nhân viên
            cuocHopMapper.insertChiTietCuocHop(cuocHopMapstruct.toChiTietCuocHop(newRecord)); // Thêm nhân viên vào cuộc họp
        }
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
