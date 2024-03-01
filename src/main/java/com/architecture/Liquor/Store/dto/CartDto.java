package com.architecture.Liquor.Store.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDto {
    @Id
    private int cid;
    private int pid;
    private int quantity;
    private int price;

}
