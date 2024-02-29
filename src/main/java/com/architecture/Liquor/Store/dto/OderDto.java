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
public class OderDto {
    @Id
    private int oid;
    private int pid;
    private int quantity;
    private int price;

}

