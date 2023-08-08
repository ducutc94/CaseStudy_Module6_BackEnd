package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductsCarts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private String statusProductsCarts = "0";
    @ManyToOne
    private Carts carts;
    @ManyToOne
    private Products products;
}
