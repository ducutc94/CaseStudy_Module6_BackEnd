package com.example.casemd6.service.impl;

import com.example.casemd6.model.Products_Carts;
import com.example.casemd6.service.IProducts_CartsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Products_CartsService implements IProducts_CartsService {
    @Override
    public Iterable<Products_Carts> findAll() {
        return null;
    }

    @Override
    public Optional<Products_Carts> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Products_Carts save(Products_Carts productsCarts) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
