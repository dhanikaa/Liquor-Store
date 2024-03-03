package com.architecture.Liquor.Store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String address;
    private String password;
    private String confirmPassword;
}
