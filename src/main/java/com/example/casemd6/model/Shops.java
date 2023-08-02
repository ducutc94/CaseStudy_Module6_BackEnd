package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
public class Shops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String description;
    private String email;
    private Time start_time;
    private Time end_time;
    private String status_shops = "0";
    @ManyToOne
    private User user;
    @ManyToOne
    private City city;
}
