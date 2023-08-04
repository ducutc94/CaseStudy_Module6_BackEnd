package com.example.casemd6.service;

import com.example.casemd6.model.Products;

import java.util.List;


public interface IProductsService extends IGeneralService<Products>{

    List<Products> findAllByName(String name);
}
