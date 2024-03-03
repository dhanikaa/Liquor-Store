package com.architecture.Liquor.Store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String address;
    private String password;
    private String confirmPassword;
}
