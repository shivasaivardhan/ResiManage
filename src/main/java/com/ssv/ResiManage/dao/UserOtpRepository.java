package com.ssv.ResiManage.dao;

import com.ssv.ResiManage.entities.UserOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOtpRepository extends JpaRepository<UserOtp,Integer> {

    UserOtp findTopByEmailOrderByCreatedAtDesc(String email);//derived queries
}
