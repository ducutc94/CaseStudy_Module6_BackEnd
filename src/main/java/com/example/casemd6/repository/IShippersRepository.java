package com.example.casemd6.repository;

import com.example.casemd6.model.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShippersRepository extends JpaRepository<Shippers,Long> {
}
