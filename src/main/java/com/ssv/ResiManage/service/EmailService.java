package com.ssv.ResiManage.service;

import com.ssv.ResiManage.dao.UserOtpRepository;
import com.ssv.ResiManage.entities.UserOtp;
import com.ssv.ResiManage.misc.AppConstants;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Service
@PropertySource("classpath:application.properties")
public class EmailService {

    private JavaMailSender javaMailSender;
    private final UserOtpRepository otpRepository;

    public EmailService(JavaMailSender javaMailSender, UserOtpRepository otpRepository) {
        this.javaMailSender = javaMailSender;
        this.otpRepository = otpRepository;
    }

    AppConstants appConstants = new AppConstants();


    public void sendOtpViaMail(String email) throws IOException, MessagingException {

        ClassPathResource resource = new ClassPathResource("templates/otp-email.html");
        String htmlContent = new String(Files.readAllBytes(resource.getFile().toPath()));
        htmlContent = htmlContent.replace("${otp}", generateOTP(email));

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("shivasaivardhan1729@gmail.com");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Otp Verification");
        mimeMessageHelper.setText(htmlContent,true);
        javaMailSender.send(mimeMessage);
    }

    public boolean verifyOtp(String otp, String email) {
        UserOtp userOtp = otpRepository.findTopByEmailOrderByCreatedAtDesc(email);
        if (userOtp == null) return false;
        long diff = Duration.between(userOtp.getCreatedAt(), LocalDateTime.now()).toMinutes();   //does b-a
        if (otp.equals(userOtp.getOtp()) && diff < 5)
            return true;
        return false;
    }

    private String generateOTP(String email) {
        String otp = String.valueOf((100000 + new Random().nextInt(900000)));
        UserOtp userOtp = UserOtp.builder().otp(otp).email(email).build();
        otpRepository.save(userOtp);
        return otp;
    }


}
