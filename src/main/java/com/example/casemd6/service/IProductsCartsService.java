package com.example.casemd6.service;

import com.example.casemd6.model.ProductsCarts;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IProductsCartsService extends IGeneralService<ProductsCarts>{
    List<ProductsCarts> findByIdUser( Long id);
    List<ProductsCarts> findByUser( Long id);
    List<ProductsCarts> findByIdUserCart( Long id);
    ProductsCarts update(ProductsCarts productsCarts);
}
