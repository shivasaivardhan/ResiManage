package com.ssv.ResiManage.dto;

import lombok.Data;
@Data
public class UserLoginDto {
    private String email;
    private String password;
    private String role;
}
