package com.example.casemd6.service.impl;

import com.example.casemd6.model.Products;
import com.example.casemd6.model.ProductsCarts;
import com.example.casemd6.repository.IProductsCartsRepository;
import com.example.casemd6.service.IProductsCartsService;
import com.example.casemd6.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsCartsService implements IProductsCartsService {
    @Autowired
    private IProductsCartsRepository iProductsCartsRepository;
    @Autowired
    private IProductsService iProductsService;
    @Override
    public Iterable<ProductsCarts> findAll() {
        return iProductsCartsRepository.findAll();
    }
    @Override
    public Optional<ProductsCarts> findOne(Long id) {
        return iProductsCartsRepository.findById(id);
    }

    @Override
    public ProductsCarts save(ProductsCarts productsCarts) {
        Products products = iProductsService.findOne(productsCarts.getProducts().getId()).get();
        products.setQuantity(products.getQuantity()-productsCarts.getQuantity());
        iProductsService.save(products);
        return iProductsCartsRepository.save(productsCarts);
    }

    @Override
    public void remove(Long id) {
        ProductsCarts productsCartsOptional = findOne(id).get();
        productsCartsOptional.setStatusProductsCarts("1");
        save(productsCartsOptional);

    }
}
