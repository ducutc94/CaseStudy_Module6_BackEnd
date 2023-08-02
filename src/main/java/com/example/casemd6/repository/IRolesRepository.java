package com.example.casemd6.repository;

import com.example.casemd6.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepository extends JpaRepository<Role,Long> {
}
