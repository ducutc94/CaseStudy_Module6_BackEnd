package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Products_Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    private Carts carts;
    @ManyToOne
    private Products products;
}
