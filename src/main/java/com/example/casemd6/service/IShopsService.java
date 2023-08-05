package com.example.casemd6.service;

import com.example.casemd6.model.Shops;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IShopsService extends IGeneralService<Shops>{
    List<Shops> findShopByUserId(Long id);
    Shops findAllByEmailIgnoreCase(String email);
    List<Shops> findAllByAdmin();

}
