package com.example.casemd6.service.impl;

import com.example.casemd6.model.Carts;
import com.example.casemd6.model.Products;
import com.example.casemd6.model.ProductsCarts;
import com.example.casemd6.repository.ICartsRepository;
import com.example.casemd6.repository.IProductsCartsRepository;
import com.example.casemd6.service.ICartsService;
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
    @Autowired
    private ICartsService iCartsService;
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
    public List<ProductsCarts> findByUser(Long id) {
        return iProductsCartsRepository.findByUser(id);
    }

    @Override
    public List<ProductsCarts> findByIdUserCart(Long id) {
        double totalPrice;
        List<ProductsCarts> productsCarts = iProductsCartsRepository.findByIdUserCart(id);
        for (ProductsCarts p :productsCarts) {
            totalPrice = p.getQuantity()*(p.getProducts().getPrice());
            p.setTotalPrice(totalPrice);
        }
        return productsCarts;
    }

    @Override
    public ProductsCarts update(ProductsCarts productsCarts) {
        return iProductsCartsRepository.save(productsCarts);
    }

    @Override
    public List<ProductsCarts> findByIdMerchant(Long id) {
        double totalPrice;
        List<ProductsCarts> productsCarts = iProductsCartsRepository.findByIdMerchant(id);
        for (ProductsCarts p :productsCarts) {
            totalPrice = p.getQuantity()*(p.getProducts().getPrice());
            p.setTotalPrice(totalPrice);
        }
        return productsCarts;
    }

    @Override
    public void deleteM(Long id) {
        ProductsCarts productsCartsOptional = findOne(id).get();
        if(productsCartsOptional !=null){
            productsCartsOptional.setStatusProductsCarts("1");
            iProductsCartsRepository.save(productsCartsOptional);
        }
    }

    @Override
    public ProductsCarts save(ProductsCarts productsCarts) {
        productsCarts.setStatusProductsCarts("2");
        Products products = iProductsService.findOne(productsCarts.getProducts().getId()).get();
        Carts carts = iCartsService.findOne(productsCarts.getCarts().getId()).get();
        Long id = carts.getUser().getId();
        List<ProductsCarts> productsCartsList = findByUser(id);
        for (ProductsCarts p:productsCartsList) {
            if(Objects.equals(products.getId(), p.getProducts().getId())
                    && p.getProducts().getPrice() == products.getPrice() && Objects.equals(p.getStatusProductsCarts(), "2")){
                p.setQuantity(p.getQuantity()+productsCarts.getQuantity());
                return iProductsCartsRepository.save(p);
            }
        }
        return iProductsCartsRepository.save(productsCarts);
    }

    @Override
    public void remove(Long id) {
        ProductsCarts productsCartsOptional = findOne(id).get();
       if(productsCartsOptional !=null){
           iProductsCartsRepository.deleteById(id);
       }

    }
}
