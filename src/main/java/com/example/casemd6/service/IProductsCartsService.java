package com.example.casemd6.service;

import com.example.casemd6.model.Bills;
import com.example.casemd6.model.Carts;
import com.example.casemd6.model.Products;
import com.example.casemd6.model.ProductsCarts;
import java.util.List;

public interface IProductsCartsService extends IGeneralService<ProductsCarts>{
    List<ProductsCarts> findByIdUser( Long id);
    List<ProductsCarts> findByUser( Long id);
    List<ProductsCarts> findByIdUserCart( Long id);
    ProductsCarts update(ProductsCarts productsCarts);
    List<ProductsCarts> findByIdMerchant( Long id);
    void deleteM(Long id);
    List<ProductsCarts> findByIdMerchantService( Long id);
    List<ProductsCarts> findByIdMerchantService( );
    ProductsCarts createS(Carts carts, Products products, int quantity);
    ProductsCarts create(Carts carts, Products products, int quantity, Bills bills);
}
