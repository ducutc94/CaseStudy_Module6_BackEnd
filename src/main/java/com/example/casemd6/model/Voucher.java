package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double percent;
    private int quantity;
    private String status_voucher = "0";
    @ManyToOne
    private Shops shops;
}
