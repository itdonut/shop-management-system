package com.example.crm.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "providers")
@Data
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
}
