package com.example.casemd6.service.impl;

import com.example.casemd6.model.Products;
import com.example.casemd6.model.ProductsCarts;
import com.example.casemd6.repository.IProductsCartsRepository;
import com.example.casemd6.service.IProductsCartsService;
import com.example.casemd6.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public List<ProductsCarts> findByIdUser(Long id) {
        double totalPrice;
        List<ProductsCarts> productsCarts = iProductsCartsRepository.findByIdUser(id);
        for (ProductsCarts p :productsCarts) {
           totalPrice = p.getQuantity()*(p.getProducts().getPrice());
           p.setTotalPrice(totalPrice);
        }

        return productsCarts;
    }

    @Override
    public ProductsCarts save(ProductsCarts productsCarts) {
        productsCarts.setStatusProductsCarts("0");
        Products products = iProductsService.findOne(productsCarts.getProducts().getId()).get();
//        products.setQuantity(products.getQuantity()-productsCarts.getQuantity());
        List<ProductsCarts> productsCartsList = (List<ProductsCarts>) findAll();
        for (ProductsCarts p:productsCartsList) {
            if(Objects.equals(products.getId(), p.getProducts().getId())
                    && p.getProducts().getPrice() == products.getPrice()){
                p.setQuantity(p.getQuantity()+productsCarts.getQuantity());
//                iProductsService.save(products);
                return iProductsCartsRepository.save(p);
            }
        }
//        iProductsService.save(products);
        return iProductsCartsRepository.save(productsCarts);
    }

    @Override
    public void remove(Long id) {
        ProductsCarts productsCartsOptional = findOne(id).get();
        productsCartsOptional.setStatusProductsCarts("1");
        save(productsCartsOptional);

    }
}
