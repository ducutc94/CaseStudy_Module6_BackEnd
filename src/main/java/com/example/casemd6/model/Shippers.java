package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Shippers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String image;
    private double percent;
    private String status_shippers = "0";
    private String status;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Shops> shops;
}
