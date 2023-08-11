package com.example.casemd6.service;

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
}
