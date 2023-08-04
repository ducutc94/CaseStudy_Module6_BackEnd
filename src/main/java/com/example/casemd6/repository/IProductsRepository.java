package com.example.casemd6.repository;

import com.example.casemd6.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IProductsRepository extends JpaRepository<Products,Long> {

    @Query(value = "select * from Products where Products .name like :name", nativeQuery = true)
    List<Products> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM products WHERE status_products = 0", nativeQuery = true)
    List<Products> findProductsByStatusZero();


}
