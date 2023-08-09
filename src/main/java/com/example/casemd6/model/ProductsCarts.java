package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class ProductsCarts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private String statusProductsCarts = "2";
    private LocalDate date;
    @ManyToOne
    private Carts carts;
    @ManyToOne
    private Products products;
    @Transient
    private double totalPrice;
}
