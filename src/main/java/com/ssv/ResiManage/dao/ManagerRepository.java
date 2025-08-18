package com.ssv.ResiManage.dao;

import com.ssv.ResiManage.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    @Query("select m from Manager m where m.email=:email")        //Named parameters
    Manager getManagerByEmail(@Param("email") String email);

    @Query("select m from Manager m where m.phoneNo= ?1")        //Positional parameters
    Manager getManagerByPhoneNo(String email);
}
