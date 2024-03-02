package com.architecture.Liquor.Store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Checkout {
    @Id
    @GeneratedValue
    private int cid;
    @ManyToOne
    private User user;
    @ManyToOne
    private Order order;
}
