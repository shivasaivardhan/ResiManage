package com.ssv.ResiManage.service;

import com.ssv.ResiManage.dao.ManagerRepository;
import com.ssv.ResiManage.dao.TenantRepository;
import com.ssv.ResiManage.dto.ManagerRegistrationDto;
import com.ssv.ResiManage.dto.TenantRegistrationDto;
import com.ssv.ResiManage.dto.UserLoginDto;
import com.ssv.ResiManage.entities.Manager;
import com.ssv.ResiManage.entities.Tenant;
import com.ssv.ResiManage.exception.UserAlreadyExistsException;
import com.ssv.ResiManage.misc.AppConstants;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final TenantRepository tenantRepository;
    private final ManagerRepository managerRepository;

    public boolean adminValidation(String email, String password) {
        System.out.println(AppConstants.admin_email);
        System.out.println(AppConstants.admin_password);
        if (email.equals(AppConstants.admin_email) && password.equals(AppConstants.admin_password)) {
            System.out.println(email + ":" + password);
            return true;
        }
        return false;
    }

    @Transactional
    public void saveManager(ManagerRegistrationDto dto) {
        if (managerRepository.getManagerByEmail(dto.getEmail()) != null)
            throw new UserAlreadyExistsException("The provided email is already used.Please try other...");
        if (managerRepository.getManagerByPhoneNo(dto.getPhoneNo()) != null)
            throw new UserAlreadyExistsException("The provided Phone Number is already used.Please try other...");
        try {
            Manager manager = Manager.of()
                    .gender(dto.getGender())
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .phoneNo(dto.getPhoneNo())
                    .age(dto.getAge())
                    .password(dto.getPassword())
                    .build();
            managerRepository.save(manager);
        } catch (Exception e) {
            throw new RuntimeException("Could not save manager: " + e.getMessage());
        }
    }

    @Transactional
    public void saveTenant(TenantRegistrationDto dto) {
        if (tenantRepository.getTenantByEmail(dto.getEmail()) != null)
            throw new UserAlreadyExistsException("The provided email is already used.Please try other...");
        if (tenantRepository.getTenantByPhoneNo(dto.getPhoneNo()) != null)
            throw new UserAlreadyExistsException("The provided Phone Number is already used.Please try other...");
        try {
            Tenant tenant = Tenant.builder()
                    .gender(dto.getGender())
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .phoneNo(dto.getPhoneNo())
                    .age(dto.getAge())
                    .password(dto.getPassword())
                    .occupation(dto.getOccupation())
                    .address(dto.getAddress())
                    .build();
            tenantRepository.save(tenant);
        } catch (Exception e) {
            throw new RuntimeException("Could not save Tenant: " + e.getMessage());
        }
    }

    public boolean updateUser(String email) {
        Manager manager = managerRepository.findByEmail(email);
        if (manager != null) {
            manager.setEmailVerified(true);
            managerRepository.save(manager);
            return true;
        }
        Tenant tenant = tenantRepository.getTenantByEmail(email);
        if (tenant != null) {
            tenant.setEmailVerified(true);
            tenantRepository.save(tenant);
            return true;
        }
        return false;
    }

    public String loginUser(UserLoginDto userLoginDto, HttpSession httpSession) {
        String role=null;
        Manager manager=managerRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        if (manager != null)
        {
            httpSession.setAttribute("loggedInUser",manager);
            role=manager.getRole();
            return role;
        }
        Tenant tenant=tenantRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        if (tenant != null)
        {
            httpSession.setAttribute("loggedInUser",tenant);
            role= tenant.getRole();;
            return role;
        }
        return role;
    }

    public boolean checkUserOtpStatus(String role,HttpSession httpSession) {
        System.out.println("entered checkUserOtpStatus");
       if(role.equals(AppConstants.MANAGER_ROLE))
       {
           Manager manager= (Manager) httpSession.getAttribute("loggedInUser");
           return manager.isEmailVerified();
       }
        if(role.equals(AppConstants.TENANT_ROLE))
        {
            Tenant tenant= (Tenant) httpSession.getAttribute("loggedInUser");
            return tenant.isEmailVerified();
        }
        return false;
    }

}
