package com.architecture.Liquor.Store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private int oid;
    private int pid;
    private int quantity;
    private int price;
}
