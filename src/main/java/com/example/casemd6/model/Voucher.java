package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double percent;
    private int quantity;
    private String statusVoucher = "0";
    @ManyToMany
    private Set<Shops> shops;
}
