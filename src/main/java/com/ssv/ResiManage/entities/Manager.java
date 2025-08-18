package com.ssv.ResiManage.entities;

import com.ssv.ResiManage.misc.AppConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
    private int age;
    private String gender;
    private String phoneNo;
    //@Builder.Default in Lombok is used to ensure default values are preserved when using the @Builder pattern.
    @Builder.Default
    private String role= AppConstants.MANAGER_ROLE;
    @Builder.Default
    private boolean emailVerified = false;
    @CreationTimestamp
    private LocalDateTime createdAt;

    //1:n mapping
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accommodation> accommodations;
}
