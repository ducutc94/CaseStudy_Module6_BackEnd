package com.example.casemd6.repository;

import com.example.casemd6.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends JpaRepository<Products,Long> {
}
