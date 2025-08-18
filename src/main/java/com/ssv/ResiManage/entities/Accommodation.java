package com.ssv.ResiManage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private double pincode;
    private double electricityRate;
    @CreationTimestamp
    private LocalDateTime createdAt;

    //n:1 mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    //1:n mapping
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "accommodation")
    private List<Tenant> tenants;
}
