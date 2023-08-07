package com.example.casemd6.service;

import com.example.casemd6.model.Shops;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface IShopsService extends IGeneralService<Shops>{
    List<Shops> findShopByUserId(Long id);
    Shops findAllByEmailIgnoreCase(String email);
    List<Shops> findAllByAdmin();
    List<Shops> findAllByUser(Long id);
//    Optional<Shops> updateShop(Shops shops);

}
