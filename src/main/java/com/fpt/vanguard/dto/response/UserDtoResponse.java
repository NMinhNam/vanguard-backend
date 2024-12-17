package com.fpt.vanguard.dto.response;

import com.fpt.vanguard.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoResponse {
    private Integer userId;
    private String userName;
    private Boolean enabled;
    private Role role;


    private String roleName;
    private String maNhanVien;
    private String tenNhanVien;
    private String dienThoai;
}
