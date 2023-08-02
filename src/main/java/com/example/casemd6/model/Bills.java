package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String status = "0";
    @ManyToOne
    private User user;
    @ManyToOne
    private Shops shops;
    private String status_bills = "0";
}
