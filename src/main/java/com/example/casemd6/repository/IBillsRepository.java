package com.example.casemd6.repository;

import com.example.casemd6.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
public interface IBillsRepository extends JpaRepository<Bills,Long> {
    Bills findAllByUser_Id(Long id);
    Bills findByShops_Id(Long id);
    @Query(value = "select * from bills s where shops_id = ? and s.status = 2;",nativeQuery = true)
    Bills findByShopIdStatus(@PathVariable Long id);

    @Query(value = "select * from bills s inner join products_carts pc on s.id = pc.bills_id where pc.id = ?;",nativeQuery = true)
    Bills findByProductsCartId(@PathVariable Long id);

    @Query(value = "select * from bills s\n" +
            "    inner join products_carts pc on s.id = pc.bills_id\n" +
            "         inner join products p on pc.products_id = p.id\n" +
            "         inner join shops s2 on p.shops_id = s2.id\n" +
            "         inner join user u on s2.user_id = u.id\n" +
            "         where u.id = ?;",nativeQuery = true)
    List<Bills> findByShopID(@PathVariable Long id);


}
