package com.ssv.ResiManage.dao;

import com.ssv.ResiManage.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TenantRepository extends JpaRepository<Tenant,Long> {
    @Query("select m from Tenant m where m.email=:email")        //Declared Queries with Named parameters
    Tenant getTenantByEmail(@Param("email") String email);

    @Query("select m from Tenant m where m.phoneNo= ?1")        //Declared Queries with Positional parameters
    Tenant getTenantByPhoneNo(String email);
}
