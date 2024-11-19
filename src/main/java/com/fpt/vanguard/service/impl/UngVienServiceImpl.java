package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.request.UngVienDtoRequest;
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
        System.out.println(ungVienDtoRequest.getTrangThai());
        return ungVienMapper.insertUngVien(ungVienMapstruct.toUngVien(ungVienDtoRequest));
    }

    @Override
    public int updateUngVien(UngVienDtoRequest ungVienDtoRequest) throws MessagingException, ParseException {
        String maUngVien = ungVienDtoRequest.getMaUngVien();
        Integer ungVienResponse =  ungVienMapper.updateUngVien(ungVienMapstruct.toUngVien(ungVienDtoRequest));
        Integer trangThaiUngVien = ungVienDtoRequest.getTrangThai();
        System.out.println(trangThaiUngVien);
        ViTriTuyenDungDtoResponse viTriUngTuyen = tuyenDungService.getTuyenDungById(ungVienDtoRequest.getMaViTriTuyenDung());
        String maViTri = "CV01";
        String maPhongBan = viTriUngTuyen.getMaPhongBan();
        Integer soLuongTuyen = viTriUngTuyen.getSoLuongTuyen();
        Integer soLuongDauPhongVan = ungVienMapper.getUngVienByViTriAndTrangThai(
                ungVienDtoRequest.getMaViTriTuyenDung()
                ,TrangThaiUngVien.DAU_PHONG_VAN.getTrangThaiUngVien())
                .toArray()
                .length;
        if (Objects.equals(trangThaiUngVien,TrangThaiUngVien.DAU_PHONG_VAN.getTrangThaiUngVien())){
            if(soLuongDauPhongVan >= soLuongTuyen){
                throw new AppException(ErrorCode.DU_UNG_VIEN_DAT_YEU_CAU);
            }
            //gửi mail
            System.out.println("gửi mail đậu phỏng vấn");

            NhanVienDtoRequest nhanVienMoi = new NhanVienDtoRequest();
            nhanVienMoi.setCccd(ungVienDtoRequest.getCccd());
            nhanVienMoi.setEmail(ungVienDtoRequest.getEmail());
            nhanVienMoi.setDiaChi(ungVienDtoRequest.getDiaChi());
            nhanVienMoi.setDienThoai(ungVienDtoRequest.getDienThoai());
            nhanVienMoi.setHinhAnh(ungVienDtoRequest.getHinhAnh());
            nhanVienMoi.setGioiTinh(ungVienDtoRequest.getGioiTinh());
            nhanVienMoi.setHoTen(ungVienDtoRequest.getHoTen());
            nhanVienMoi.setMaPhongBan(maPhongBan);
            nhanVienMoi.setMaChucVu(maViTri);
            nhanVienService.createNhanVien(nhanVienMoi);
        }

        if (Objects.equals(trangThaiUngVien,TrangThaiUngVien.ROT_PHONG_VAN.getTrangThaiUngVien())) {
            //gửi mail
            System.out.println("gửi mail rớt phỏng vấn");
        }

        if (Objects.equals(trangThaiUngVien,TrangThaiUngVien.PHONG_VAN.getTrangThaiUngVien())) {
            //gửi mail
            System.out.println("gửi mail đi phỏng vấn");
        }
        return ungVienResponse;
    }

    @Override
    public UngVienDtoResponse getUngVienByMaUngVien(String maUngVien) {
        UngVienDtoResponse ungVien = ungVienMapstruct.toUngVienDtoResponse(ungVienMapper.getUngVienById(maUngVien));
        if(ungVien != null)
            throw new AppException(ErrorCode.UNG_VIEN_KHONG_TON_TAI);
        return ungVien;
    }
}
