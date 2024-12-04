package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.request.UngVienDtoRequest;
import com.fpt.vanguard.dto.response.PhongBanDtoResponse;
import com.fpt.vanguard.dto.response.UngVienDtoResponse;
import com.fpt.vanguard.dto.response.ViTriTuyenDungDtoResponse;
import com.fpt.vanguard.entity.UngVien;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.enums.TrangThaiUngVien;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mapstruct.UngVienMapstruct;
import com.fpt.vanguard.mapper.mybatis.UngVienMapper;
import com.fpt.vanguard.service.MailService;
import com.fpt.vanguard.service.NhanVienService;
import com.fpt.vanguard.service.TuyenDungService;
import com.fpt.vanguard.service.UngVienService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UngVienServiceImpl implements UngVienService {
    private final UngVienMapper ungVienMapper;
    private final UngVienMapstruct ungVienMapstruct;
    private final MailService mailService;
    private final NhanVienService nhanVienService;
    private final TuyenDungService tuyenDungService;

    @Override
    public List<UngVienDtoResponse> getUngVien(String tenViTri) {
        List<UngVien> responseList = ungVienMapper.findAll(tenViTri);
        if (responseList.isEmpty()) throw new AppException(ErrorCode.LIST_UNG_VIEN_EMPTY);

        return ungVienMapstruct.toUngVienDtoResponseList(responseList);
    }

    @Override
    public int saveUngVien(UngVienDtoRequest ungVienDtoRequest) throws MessagingException, ParseException {
        if (ungVienMapper.isExistUngVien(ungVienDtoRequest.getMaUngVien()))
            return updateUngVien(ungVienDtoRequest);
        return insertUngVien(ungVienDtoRequest);
    }

    @Override
    public int insertUngVien(UngVienDtoRequest ungVienDtoRequest) {
        Integer trangThaiMacDinh = TrangThaiUngVien.CHO_DUYET.getTrangThaiUngVien();
        ungVienDtoRequest.setTrangThai(trangThaiMacDinh);
        return ungVienMapper.insertUngVien(ungVienMapstruct.toUngVien(ungVienDtoRequest));
    }

    @Override
    public int updateUngVien(UngVienDtoRequest ungVienDtoRequest) throws MessagingException, ParseException {
        String maUngVien = ungVienDtoRequest.getMaUngVien();
        Integer trangThaiUngVien = ungVienDtoRequest.getTrangThai();
        ViTriTuyenDungDtoResponse viTriUngTuyen = tuyenDungService.getTuyenDungById(ungVienDtoRequest.getMaViTriTuyenDung());
        Integer soLuongTuyen = viTriUngTuyen.getSoLuongTuyen();
        Integer soLuongDauPhongVan = ungVienMapper.getUngVienByViTriAndTrangThai(
                        ungVienDtoRequest.getMaViTriTuyenDung(),
                        TrangThaiUngVien.NHAN_VIEC.getTrangThaiUngVien())
                .toArray().length;
        if (Objects.equals(trangThaiUngVien, TrangThaiUngVien.NHAN_VIEC.getTrangThaiUngVien())) {
            if (soLuongDauPhongVan >= soLuongTuyen) {
                throw new AppException(ErrorCode.DU_UNG_VIEN_DAT_YEU_CAU);
            }
        }
        Integer ungVienResponse = ungVienMapper.updateUngVien(ungVienMapstruct.toUngVien(ungVienDtoRequest));
        if (ungVienResponse != null) {
            if (Objects.equals(trangThaiUngVien, TrangThaiUngVien.PHONG_VAN_LAN_1.getTrangThaiUngVien())) {
                // Gửi email khi ứng viên phỏng vấn lần 1
                System.out.println("Gửi mail đi phỏng vấn lần 1");
            }

            if (Objects.equals(trangThaiUngVien, TrangThaiUngVien.PHONG_VAN_LAN_2.getTrangThaiUngVien())) {
                // Gửi email khi ứng viên phỏng vấn lần 2
                System.out.println("Gửi mail đi phỏng vấn lần 2");
            }

            if (Objects.equals(trangThaiUngVien, TrangThaiUngVien.NHAN_VIEC.getTrangThaiUngVien())) {
                // Gửi email khi ứng viên đậu phỏng vấn
                System.out.println("Gửi mail đậu phỏng vấn");
            }

            if (Objects.equals(trangThaiUngVien, TrangThaiUngVien.TU_CHOI.getTrangThaiUngVien())) {
                // Gửi email khi ứng viên bị từ chối
                System.out.println("Gửi mail rớt phỏng vấn");
                deleteUngVien(maUngVien);
            }
        }

        return ungVienResponse;
    }


    @Override
    public UngVienDtoResponse getUngVienByMaUngVien(String maUngVien) {
        UngVienDtoResponse resultEntity = ungVienMapstruct.toUngVienDtoResponse(
                ungVienMapper.getUngVienById(maUngVien)
        );
        if (!Objects.nonNull(resultEntity)) throw new AppException(ErrorCode.UNG_VIEN_KHONG_TON_TAI);
        return resultEntity;
    }

    @Override
    public int deleteUngVien(String maUngVien) {
        if (!ungVienMapper.isExistUngVien(maUngVien)) throw new AppException(ErrorCode.UNG_VIEN_KHONG_TON_TAI);
        return ungVienMapper.deleteUngVien(maUngVien);
    }

    @Override
    public List<UngVienDtoResponse> getUngVienByViTriAndTrangThai(String maViTri, int trangThai) throws MessagingException, ParseException {
        List<UngVienDtoResponse> listResultEntity = ungVienMapstruct.toUngVienDtoResponseList(
                ungVienMapper.getUngVienByViTriAndTrangThai(maViTri, trangThai)
        );
        return listResultEntity;
    }
}
