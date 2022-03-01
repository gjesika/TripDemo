package com.example.tripdemo.database.entities;

import com.example.tripdemo.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    private boolean isEnabled;


}
