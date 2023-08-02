package com.example.casemd6.repository;

import com.example.casemd6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findAllByUsername(String username);
    User findAllByEmailIgnoreCase(String email);
}
