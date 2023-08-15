package com.example.casemd6.service;

import com.example.casemd6.model.Products;

import java.util.List;


public interface IProductsService extends IGeneralService<Products>{
    List<Products> findAllByName(String name);
    List<Products> findProductByCategory(Long productId);
    List<Products> findProductByCity(Long CityId);
    List<Products> findProductsByCategoryIdAndCityId(Long categoryId,Long cityId);
    List<Products> sortByPriceAsc();
    List<Products> sortByPriceDesc();
    List<Products> sortByViewDesc();
    List<Products> findProductsByShopId(Long shopId);
}
