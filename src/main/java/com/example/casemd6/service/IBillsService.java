package com.example.casemd6.service;

import com.example.casemd6.model.Bills;
import com.example.casemd6.model.ProductsCarts;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IBillsService extends IGeneralService<Bills> {
    List<Bills> listBills(List<ProductsCarts> productsCarts,Long id);
    List<Bills> billsDone(List<ProductsCarts> productsCarts,Long id);
    Bills createById(Long id);
    Bills findByShops_Id(Long id);
    Bills findByProductsCartId( Long id);
    List<Bills> findByShopID( Long id);
    List<Bills> findBillByUserID( Long id);
    List<Bills> findBillByShopID( Long useId,Long shopId);
    List<Bills> findBillByShopIDFilter( Long userId, Long shopId);

    List<Bills> findByUser( Long id);
    List<Bills> findAllByMerchant( Long id);
}
