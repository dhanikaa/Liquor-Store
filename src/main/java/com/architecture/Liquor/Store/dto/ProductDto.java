package com.architecture.Liquor.Store.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProductDto {
    private int pid;
    private String pname;
    private String catergory;
    private int Quantity;
}
