package com.example.casemd6.service.impl;

import com.example.casemd6.model.Carts;
import com.example.casemd6.service.ICartsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartsService implements ICartsService {
    @Override
    public Iterable<Carts> findAll() {
        return null;
    }

    @Override
    public Optional<Carts> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Carts save(Carts carts) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
