package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.request.NhanVienDtoRequest;
import com.fpt.vanguard.dto.request.UserDtoRequest;
import com.fpt.vanguard.dto.response.NhanVienDtoResponse;
import com.fpt.vanguard.dto.response.UserDtoResponse;
import com.fpt.vanguard.entity.NhanVien;
import com.fpt.vanguard.enums.Roles;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.mapper.mapstruct.NhanVienMapstruct;
import com.fpt.vanguard.mapper.mybatis.NhanVienMapper;
import com.fpt.vanguard.service.MailService;
import com.fpt.vanguard.service.NhanVienService;
import com.fpt.vanguard.service.UserService;
import com.fpt.vanguard.util.PasswordGeneratorUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienMapper nhanVienMapper;
    private final NhanVienMapstruct nhanVienMapstruct;
    private final MailService mailService;
    private final UserService userService;

    @Override
    public List<NhanVienDtoResponse> getAllNhanVien() {
        var listEntity = nhanVienMapper.findAll();
        List<NhanVienDtoResponse> listResultEntity = nhanVienMapstruct.toNhanVienDtoResponseList(listEntity);
        if (listResultEntity.isEmpty()) throw new AppException(ErrorCode.LIST_NHAN_VIEN_EMPTY);
        return listResultEntity;
    }

    @Override
    public NhanVienDtoResponse getNhanVienById(String id) {
        return nhanVienMapstruct.toNhanVienDtoResponse(Optional.ofNullable(nhanVienMapper.findById(id)).orElseThrow(() -> new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST)));
    }

    @Override
    public NhanVienDtoResponse getNhanVien(NhanVienDtoRequest nhanVienDtoRequest) {
        NhanVien nhanVien = nhanVienMapper.findNhanVien(nhanVienMapstruct.toNhanVien(nhanVienDtoRequest));
        return nhanVienMapstruct.toNhanVienDtoResponse(nhanVien);
    }

    @Override
    public Integer createNhanVien(NhanVienDtoRequest nhanVienDtoRequest) throws MessagingException, ParseException {
        String nhanVienId = nhanVienDtoRequest.getMaNhanVien();
        if (nhanVienMapper.existsById(nhanVienId))
            throw new AppException(ErrorCode.NHAN_VIEN_EXISTED);

        String email = nhanVienDtoRequest.getEmail();
        String name = nhanVienDtoRequest.getHoTen();
        String password = PasswordGeneratorUtil.generateRandomPassword();
        Integer roleId = Roles.USER.getRoleId();

        if (nhanVienMapper.existsByEmail(email))
            throw new AppException(ErrorCode.EMAIL_EXISTED);

        UserDtoRequest userDtoRequest = UserDtoRequest.builder()
                .username(email)
                .password(password)
                .roleId(roleId)
                .build();
        userService.createUser(userDtoRequest);

        sendWelcomeEmail(email, name);

        sendAccountCreationEmail(email, name, password);

        UserDtoResponse user = userService.getUserByUserName(email);
        nhanVienDtoRequest.setUserId(user.getUserId());

        return nhanVienMapper.insertNhanVien(
                nhanVienMapstruct.toNhanVien(nhanVienDtoRequest)
        );
    }

    private void sendWelcomeEmail(String email, String name) throws MessagingException {
        Map<String, Object> welcomeVariables = new HashMap<>();
        welcomeVariables.put("name", name);

        MailDtoRequest welcomeMailDtoRequest = MailDtoRequest.builder()
                .to(email)
                .subject("Welcome to the Vanguard Team!")
                .templateName("welcome-mail.html")
                .variables(welcomeVariables)
                .build();

        mailService.sendMail(welcomeMailDtoRequest);
    }

    private void sendAccountCreationEmail(String email, String name, String password) throws MessagingException {
        Map<String, Object> accountCreationVariables = new HashMap<>();
        accountCreationVariables.put("name", name);
        accountCreationVariables.put("username", email);
        accountCreationVariables.put("password", password);

        MailDtoRequest accountCreationMailDtoRequest = MailDtoRequest.builder()
                .to(email)
                .subject("Your Account Has Been Created!")
                .templateName("account-creation-notification.html")
                .variables(accountCreationVariables)
                .build();

        mailService.sendMail(accountCreationMailDtoRequest);
    }

    @Override
    public Integer updateNhanVien(NhanVienDtoRequest nhanVienDtoRequest) {
        String maNhanVien = nhanVienDtoRequest.getMaNhanVien();
        boolean isExistNhanVien = nhanVienMapper.existsById(maNhanVien);
        if (!isExistNhanVien) throw new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST);
        return nhanVienMapper.updateNhanVien(
                nhanVienMapstruct.toNhanVien(nhanVienDtoRequest)
        );
    }

    @Override
    public Integer deleteNhanVien(String id) {
        boolean isExistNhanVien = nhanVienMapper.existsById(id);
        if (!isExistNhanVien) throw new AppException(ErrorCode.NHAN_VIEN_NOT_EXIST);
        return nhanVienMapper.deleteNhanVien(id);
    }
}
