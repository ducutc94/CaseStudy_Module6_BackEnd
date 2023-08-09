package com.example.casemd6.repository;

import com.example.casemd6.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface IBillsRepository extends JpaRepository<Bills,Long> {
    @Query(value = "select * from bills inner join shops s  on bills.shops_id = s.id \n" +
            "    inner join user u on bills.user_id = u.id and s.user_id = ? where status_bills = '0';",nativeQuery = true)
    List<Bills> findAllStatus(@PathVariable Long id);
}
