package com.example.casemd6.repository;

import com.example.casemd6.model.Products_Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProducts_CartsRepository extends JpaRepository<Products_Carts,Long> {
}
