package com.architecture.Liquor.Store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactDto {
    private int id;
    private String name;
    private String email;
    private String message;
}
