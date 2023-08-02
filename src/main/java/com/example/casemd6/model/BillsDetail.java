package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BillsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double total_price;
    @ManyToOne
    private Products products;
    @ManyToOne
    private Bills bills;
}
