package com.ssv.ResiManage.controller;

import com.ssv.ResiManage.dto.ManagerRegistrationDto;
import com.ssv.ResiManage.dto.UserLoginDto;
import com.ssv.ResiManage.dto.TenantRegistrationDto;
import com.ssv.ResiManage.exception.UserAlreadyExistsException;
import com.ssv.ResiManage.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/manager/registration")
    public String magagerSignUp(Model model) {
        model.addAttribute("user", new TenantRegistrationDto());
        return "manager-registration";
    }

    @GetMapping("/tenant/registration")
    public String tenantSignUp(Model model) {
        model.addAttribute("user", new TenantRegistrationDto());
        return "tenant-registration";
    }

    @GetMapping("/admin/login")
    public String adminLogin(Model model) {
        model.addAttribute("user", new UserLoginDto());
        return "admin-login";
    }

    @GetMapping("/login")
    public String userLogin(Model model) {
        model.addAttribute("user", new UserLoginDto());
        return "user-login";
    }


    @PostMapping("/signin/verify")
    public String login(@ModelAttribute("user") UserLoginDto userLoginDto, Model model) {
        if (userService.loginUser(userLoginDto)) {
            if (userService.checkUserOtpStatus(userLoginDto)) {
                model.addAttribute("user", userLoginDto);
                return "home";
            }
            model.addAttribute("msg", "Please complete the email verification process to login.");
            model.addAttribute("user", userLoginDto);
            return "user-login";
        }
        model.addAttribute("msg", "Invalid Credentials.Please try again...");
        model.addAttribute("user", new UserLoginDto());
        return "user-login";
    }


    @GetMapping("/admin-dashboard")
    public String adminValidation(@ModelAttribute("user") UserLoginDto userLoginDto, Model model) {
        System.out.println(userLoginDto);
        if (userService.adminValidation(userLoginDto.getEmail(), userLoginDto.getPassword())) {
            return "admin-dashboard";
        }
        model.addAttribute("user", userLoginDto);
        model.addAttribute("msg", "Invalid Credentials.Please try again...");
        return "admin-login";
    }

    @PostMapping("/manager/save")
    public String addManager(@Valid @ModelAttribute("user") ManagerRegistrationDto managerDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "manager-registration";
        try {
            userService.saveManager(managerDto);
            return "redirect:/otp/email/" + managerDto.getEmail();//For OTP Verification
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("msg", e.getMessage());
            return "manager-registration";
        }
    }

    @PostMapping("/tenant/save")
    public String addTenant(@Valid @ModelAttribute("user") TenantRegistrationDto tenantDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "tenant-registration";
        try {
            userService.saveTenant(tenantDto);
            return "redirect:/otp/email/" + tenantDto.getEmail();//For OTP Verification
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("msg", e.getMessage());
            return "tenant-registration";
        }
    }


}

