package com.ssv.ResiManage.entities;

import com.ssv.ResiManage.misc.AppConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String gender;
    private String occupation;
    private String email;
    private String password;
    private String address;
    private String phoneNo;
    //@Builder.Default in Lombok is used to ensure default values are preserved when using the @Builder pattern.
    @Builder.Default
    private String role= AppConstants.MANAGER_ROLE;
    @Builder.Default
    private boolean emailVerified = false;
    @CreationTimestamp
    private LocalDateTime createdAt;

    //1 mapping
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "accomadation_id",nullable = true)
    private Accommodation accommodation;
}
