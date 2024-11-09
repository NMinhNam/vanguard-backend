package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.ApprovalDetailsDtoRequest;
import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.request.PheDuyetDtoRequest;
import com.fpt.vanguard.dto.response.PheDuyetDtoResponse;
import com.fpt.vanguard.entity.DonYeuCau;
import com.fpt.vanguard.entity.PheDuyet;
import com.fpt.vanguard.enums.TrangThaiPheDuyet;
import com.fpt.vanguard.mapper.mapstruct.ApprovalMapstruct;
import com.fpt.vanguard.mapper.mapstruct.PheDuyetMapstruct;
import com.fpt.vanguard.mapper.mybatis.DonYeuCauMapper;
import com.fpt.vanguard.mapper.mybatis.PheDuyetMapper;
import com.fpt.vanguard.service.MailService;
import com.fpt.vanguard.service.PheDuyetService;
import com.fpt.vanguard.util.DateUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PheDuyetServiceImpl implements PheDuyetService {
    private final PheDuyetMapper pheDuyetMapper;
    private final PheDuyetMapstruct pheDuyetMapstruct;
    private final MailService mailService;
    private final ApprovalMapstruct approvalMapstruct;
    private final DonYeuCauMapper donYeuCauMapper;

    @Override
    public List<PheDuyetDtoResponse> getPheDuyets(String maNhanvien) {
        return pheDuyetMapstruct.toDtoList(pheDuyetMapper.findAll(maNhanvien));
    }

    @Override
    public Integer createPheDuyet(PheDuyetDtoRequest request) throws MessagingException {
        Integer trangThaiMacDinh = TrangThaiPheDuyet.CHO_DUYET.getTrangThaiPheDuyet();
        request.setTrangThai(trangThaiMacDinh);

        Integer pheDuyetResponse = pheDuyetMapper.insertPheDuyet(pheDuyetMapstruct.toPheDuyet(request));

        String maNguoiPheDuyet = request.getMaNhanVien();
        sendApprovalNotificationEmail(approvalMapstruct.toApprovalDetailsDtoRequest(pheDuyetMapper.getApprovalDetails(maNguoiPheDuyet)));

        return pheDuyetResponse;
    }

    public void sendApprovalNotificationEmail(ApprovalDetailsDtoRequest response) throws MessagingException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("approverName", response.getHoTenNguoiPheDuyet());
        variables.put("employeeName", response.getHoTenNguoiTao());
        variables.put("requestType", response.getLoaiDon());
        variables.put("requestDate", response.getNgayTao());
        variables.put("details", response.getLyDo());

        MailDtoRequest mailDtoRequest = MailDtoRequest.builder().to(response.getEmailNguoiPheDuyet()).subject("New Request for Your Approval").templateName("approval-notification.html").variables(variables).build();

        mailService.sendMail(mailDtoRequest);
    }

    @Override
    public Integer updatePheDuyet(PheDuyetDtoRequest request) throws MessagingException, ParseException {
        Integer pheDuyetResponse = pheDuyetMapper.updatePheDuyet(
                pheDuyetMapstruct.toPheDuyet(request)
        );

        String maDonYeuCau = request.getMaDon();
        Integer trangThaiDon = getRequestStatus(maDonYeuCau);
        DonYeuCau donYeuCau = donYeuCauMapper.findDonYeuCauDetail(maDonYeuCau);
        donYeuCau.setTrangThai(trangThaiDon);

        String ngayTao = donYeuCau.getNgayTao();
        DateUtil.parseDate(ngayTao);

        donYeuCau.setNgayTao(ngayTao);
        donYeuCauMapper.updateDonYeuCau(donYeuCau);

        if (!Objects.equals(trangThaiDon, TrangThaiPheDuyet.CHO_DUYET.getTrangThaiPheDuyet())) {
            String maNguoiPheDuyet = request.getMaNhanVien();
            sendApprovalStatusUpdateEmail(
                    approvalMapstruct.toApprovalDetailsDtoRequest(
                            pheDuyetMapper.getInfoFromRequestApproval(maNguoiPheDuyet)
                    )
            );
        }

        return pheDuyetResponse;
    }

    private Integer getRequestStatus(String maDonYeuCau) {
        PheDuyet requestStatus = pheDuyetMapper.getApprovalStatusCount(maDonYeuCau);
        int soLuongTuChoi = requestStatus.getSoLuongTuChoi();
        int soLuongChoDuyet = requestStatus.getSoLuongChoDuyet();
        return TrangThaiPheDuyet.getTrangThaiPheDuyet(soLuongTuChoi, soLuongChoDuyet);
    }

    public void sendApprovalStatusUpdateEmail(ApprovalDetailsDtoRequest approvalDetails) throws MessagingException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("hoTenNguoiPheDuyet", approvalDetails.getHoTenNguoiPheDuyet());
        variables.put("hoTenNguoiTao", approvalDetails.getHoTenNguoiTao());
        variables.put("loaiDon", approvalDetails.getLoaiDon());
        variables.put("ngayTao", approvalDetails.getNgayTao());
        variables.put("lyDo", approvalDetails.getLyDo());

        Integer trangThai = approvalDetails.getTrangThai();
        String tenTrangThai = TrangThaiPheDuyet.getTenTrangThai(trangThai);
        variables.put("trangThai", tenTrangThai);

        MailDtoRequest mailDtoRequest = MailDtoRequest.builder().to(approvalDetails.getEmailNguoiTao()).subject("Update on Your Approval Request").templateName("approval-status-update.html").variables(variables).build();

        mailService.sendMail(mailDtoRequest);
    }

    @Override
    public Integer deletePheDuyet(String maDon) {
        return pheDuyetMapper.deletePheDuyet(maDon);
    }

    @Override
    public PheDuyetDtoResponse getPheDuyetDetail(PheDuyetDtoRequest request) {
        return pheDuyetMapstruct.toDto(
                pheDuyetMapper.getPheDuyet(
                        pheDuyetMapstruct.toPheDuyet(request)
                )
        );
    }
}
