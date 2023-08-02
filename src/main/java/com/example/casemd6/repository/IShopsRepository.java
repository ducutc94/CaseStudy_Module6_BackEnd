package com.example.casemd6.repository;

import com.example.casemd6.model.Shops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopsRepository extends JpaRepository<Shops,Long> {
}
