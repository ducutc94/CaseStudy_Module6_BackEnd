package com.example.casemd6.repository;

import com.example.casemd6.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface IBillsRepository extends JpaRepository<Bills,Long> {
    @Query(value = "select * from bills inner join products_carts pc on bills.products_carts_id = pc.id " +
            "inner join carts c on pc.carts_id = c.id " +
            "inner join user u on c.user_id = u.id and user_id = ?;",nativeQuery = true)
    List<Bills> findAllByUser(@PathVariable Long id);
}
