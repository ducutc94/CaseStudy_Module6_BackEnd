package com.example.casemd6.service.impl;

import com.example.casemd6.model.Shippers;
import com.example.casemd6.service.IShippersService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippersService implements IShippersService {
    @Override
    public Iterable<Shippers> findAll() {
        return null;
    }

    @Override
    public Optional<Shippers> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Shippers save(Shippers shippers) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
