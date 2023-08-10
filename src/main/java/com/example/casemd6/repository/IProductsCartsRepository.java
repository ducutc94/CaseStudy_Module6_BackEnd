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
            "    inner join carts c on p.carts_id = c.id inner join user u on  c.user_id = u.id where user_id = ? and p.status_products_carts = 2;",nativeQuery = true)
    List<ProductsCarts> findByIdUser(@PathVariable Long id);

    @Query(value = "select * from products_carts p\n" +
            "    inner join carts c on p.carts_id = c.id inner join user on  c.user_id = user.id where user_id = ?;",nativeQuery = true)
    List<ProductsCarts> findByUser(@PathVariable Long id);
    @Query(value = "select * from products_carts p inner join products p2 on p.products_id = p2.id\n" +
            "    inner join carts c on p.carts_id = c.id inner join user u on  c.user_id = u.id where user_id = ? and  (p.status_products_carts = 2 or p.status_products_carts = 5);",nativeQuery = true)
    List<ProductsCarts> findByIdUserCart(@PathVariable Long id);
    @Query(value = "select * from products_carts p inner join products p2 on p.products_id = p2.id\n" +
            "    inner join carts c on p.carts_id = c.id inner join user u on  c.user_id = u.id where user_id = ? and p.status_products_carts != 2 ",nativeQuery = true)
    List<ProductsCarts> findByIdMerchant(@PathVariable Long id);

    @Query(value = "select *\n" +
            "from products_carts p\n" +
            "         inner join products p2 on p.products_id = p2.id\n" +
            "         inner join shops s on p2.shops_id = s.id\n" +
            "         inner join user u on s.user_id = u.id\n" +
            "where user_id = ? and p.status_products_carts != 2; ",nativeQuery = true)
    List<ProductsCarts> findByIdMerchantService(@PathVariable Long id);

}
