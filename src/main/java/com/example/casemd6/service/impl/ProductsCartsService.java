package com.example.casemd6.service.impl;

import com.example.casemd6.model.ProductsCarts;
import com.example.casemd6.service.IProductsCartsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsCartsService implements IProductsCartsService {
    @Override
    public Iterable<ProductsCarts> findAll() {
        return null;
    }

    @Override
    public Optional<ProductsCarts> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductsCarts save(ProductsCarts productsCarts) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
