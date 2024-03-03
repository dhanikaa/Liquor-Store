package com.architecture.Liquor.Store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private int cid;
    private int pid;
    private int quantity;
    private int price;
}
