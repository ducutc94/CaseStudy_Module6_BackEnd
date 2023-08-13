package com.example.casemd6.repository;

import com.example.casemd6.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

public interface IBillsRepository extends JpaRepository<Bills,Long> {
    Bills findAllByUser_Id(Long id);
    Bills findByShops_Id(Long id);
    @Query(value = "select * from bills s where shops_id = ? and s.status = 2;",nativeQuery = true)
    Bills findByShopIdStatus(@PathVariable Long id);
}
