package com.architecture.Liquor.Store.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int id;

    private String f_Name;
    private String l_Name;
    private String role;
    private String email;
    private String password;
}
