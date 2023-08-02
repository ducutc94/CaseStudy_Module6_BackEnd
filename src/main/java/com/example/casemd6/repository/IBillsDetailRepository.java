package com.example.casemd6.repository;

import com.example.casemd6.model.BillsDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillsDetailRepository extends JpaRepository<BillsDetail,Long> {
}
