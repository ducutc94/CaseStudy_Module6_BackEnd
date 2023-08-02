package com.example.casemd6.repository;

import com.example.casemd6.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillsRepository extends JpaRepository<Bills,Long> {
}
