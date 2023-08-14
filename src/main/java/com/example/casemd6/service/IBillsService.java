package com.example.casemd6.service;

import com.example.casemd6.model.Bills;
import com.example.casemd6.model.ProductsCarts;

import java.util.List;

public interface IBillsService extends IGeneralService<Bills> {
    List<Bills> listBills(List<ProductsCarts> productsCarts,Long id);
    Bills createById(Long id);
    Bills findByShops_Id(Long id);


}
