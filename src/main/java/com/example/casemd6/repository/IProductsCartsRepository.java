package com.example.casemd6.repository;

import com.example.casemd6.model.ProductsCarts;
import com.example.casemd6.model.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface IProductsCartsRepository extends JpaRepository<ProductsCarts,Long> {
    @Query(value = "select * from products_carts p inner join products p2 on p.products_id = p2.id\n" +
            "    inner join carts c on p.carts_id = c.id inner join user u on  c.user_id = u.id where user_id = ?;",nativeQuery = true)
    List<ProductsCarts> findByIdUser(@PathVariable Long id);
}
