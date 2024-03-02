package com.architecture.Liquor.Store.entity;

import jakarta.persistence.*;
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
    private int uid;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String address;
    private String password;
    private String confirmPassword;
}
