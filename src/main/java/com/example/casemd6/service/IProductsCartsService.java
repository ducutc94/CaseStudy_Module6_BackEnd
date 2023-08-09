package com.example.casemd6.service;

import com.example.casemd6.model.ProductsCarts;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductsCartsService extends IGeneralService<ProductsCarts>{
    List<ProductsCarts> findByIdUser( Long id);
}
