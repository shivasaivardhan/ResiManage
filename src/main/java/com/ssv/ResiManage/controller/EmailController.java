package com.ssv.ResiManage.controller;

import com.ssv.ResiManage.dto.UserLoginDto;
import com.ssv.ResiManage.service.EmailService;
import com.ssv.ResiManage.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class EmailController {

    private final EmailService emailService;
    private final UserService userService;

    public EmailController(EmailService emailService, UserService userService) {
        this.emailService = emailService;
        this.userService = userService;
    }

    @GetMapping("/otp/email/{emailid}")
    public String getOTP(@PathVariable("emailid") String email, Model model) throws IOException, MessagingException {
        emailService.sendOtpViaMail(email);
        model.addAttribute("email", email);
        return "enter-otp";
    }

    @PostMapping("/otp/verify")
    public String verifyOTP(@RequestParam("otp") String otp, @RequestParam("email") String email, Model model) {

        if (emailService.verifyOtp(otp, email)) {
            userService.updateUser(email);
            model.addAttribute("msg", "OTP Verification completed");
            model.addAttribute("user", new UserLoginDto());
            return "user-login";
        }
        model.addAttribute("msg", "OTP Verification failed.Please try again...");
        model.addAttribute("user", new UserLoginDto());
        return "user-login";
    }
}
