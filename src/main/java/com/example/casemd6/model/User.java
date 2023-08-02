package com.example.casemd6.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Date birthday;
    private String gender;
    private String image;
    private String status_user = "0" ;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @ManyToOne
    private City city;
}
