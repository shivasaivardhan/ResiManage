package com.ssv.ResiManage.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class TenantRegistrationDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotNull(message = "Age cannot be blank")
    @Min(value = 18,message = "Age must be valid one")
    private int age;
    @NotBlank(message = "Gender cannot be blank")
    private String gender;
    @NotBlank(message = "Occupation cannot be blank")
    private String occupation;
    @Email(message = "Please enter a valid email")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    @Length(min = 8,message = "Password must be strong and minimum of 8 characters")
    private String password;
    @NotBlank(message = "Address cannot be blank")
    private String address;
    @NotBlank(message = "Phone Number cannot be blank")
    @Length(min = 10,max = 12,message = "Phone Number must be a valid one")
    private String phoneNo;
    private boolean termsAccepted;

}
