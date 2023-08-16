package com.example.casemd6.service;

import com.example.casemd6.model.Bills;
import com.example.casemd6.model.ProductsCarts;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IBillsService extends IGeneralService<Bills> {
    List<Bills> listBills(List<ProductsCarts> productsCarts,Long id);
    Bills createById(Long id);
    Bills findByShops_Id(Long id);
    Bills findByProductsCartId( Long id);
    List<Bills> findByShopID( Long id);


}
