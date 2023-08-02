package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
}
