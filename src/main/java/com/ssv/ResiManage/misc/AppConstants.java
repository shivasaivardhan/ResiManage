package com.ssv.ResiManage.misc;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@Data
public class AppConstants {
    public static final String ADMIN_ROLE = "ADMIN";
    public static final String MANAGER_ROLE = "MANAGER";
    public static final String TENANT_ROLE = "TENANT";

    public static final String admin_email = "johnwick@gmail.com";
    public static final String admin_password = "12345678";
    public String otp;
}
