package com.example.casemd6.service.impl;

import com.example.casemd6.model.Role;
import com.example.casemd6.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Optional<Role> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
