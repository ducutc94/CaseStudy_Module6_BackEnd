package com.example.casemd6.service.impl;

import com.example.casemd6.model.Products;
import com.example.casemd6.service.IProductsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService implements IProductsService {
    @Override
    public Iterable<Products> findAll() {
        return null;
    }

    @Override
    public Optional<Products> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Products save(Products products) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
