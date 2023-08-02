package com.example.casemd6.repository;

import com.example.casemd6.model.ProductsCarts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsCartsRepository extends JpaRepository<ProductsCarts,Long> {
}
