package com.example.casemd6.service.impl;

import com.example.casemd6.model.Bills;
import com.example.casemd6.model.ProductsCarts;
import com.example.casemd6.model.User;
import com.example.casemd6.repository.IBillsRepository;
import com.example.casemd6.service.IBillsService;
import com.example.casemd6.service.IProductsCartsService;
import com.example.casemd6.service.IShopsService;
import com.example.casemd6.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BillsService implements IBillsService {
    @Autowired
    private IBillsRepository iBillsRepository;
    @Autowired
    private IShopsService iShopsService;
    @Autowired
    private UserService iUserService;
    @Autowired
    private IProductsCartsService iProductsCartsService;

    @Override
    public Iterable<Bills> findAll() {
        return iBillsRepository.findAll();
    }

    @Override
    public Optional<Bills> findOne(Long id) {
        return iBillsRepository.findById(id);
    }

    @Override
    public Bills save(Bills bills) {
        return iBillsRepository.save(bills);
    }

    @Override
    public void remove(Long id) {
        iBillsRepository.deleteById(id);
    }

    @Override
    public List<Bills> listBills(List<ProductsCarts> productsCarts, Long id) {
        List<Bills> billsList = new ArrayList<>();
        ProductsCarts p = productsCarts.get(0);
        Bills bills = new Bills();
        bills.setUser(iUserService.findOne(id));
        bills.setShops(iShopsService.findOne(p.getProducts().getShops().getId()).get());
        save(bills);
        p.setBills(bills);
        iProductsCartsService.save(p);
        billsList.add(bills);
        if (productsCarts.size() > 1) {
            int index = 0;
            boolean flag = true;
            for (int i = 1; i < productsCarts.size(); i++) {
                for (int j = 0; j < billsList.size(); j++) {
                    if (Objects.equals(billsList.get(j).getShops().getId(), productsCarts.get(i).getProducts().getShops().getId())) {
                        index = j;
                        flag=false;
                       break;
                    }
                }
                if (flag) {
                    Bills bills1 = new Bills();
                    bills1.setUser(iUserService.findOne(id));
                    bills1.setShops(iShopsService.findOne(productsCarts.get(i).getProducts().getShops().getId()).get());
                    save(bills1);
                    productsCarts.get(i).setBills(bills1);
                    iProductsCartsService.save(productsCarts.get(i));
                    billsList.add(bills1);
                } else {
                    productsCarts.get(i).setBills(billsList.get(index));
                    iProductsCartsService.save(productsCarts.get(i));
                }


            }
        }

        return billsList;
    }

    @Override
    public Bills createById(Long id) {
        Bills bills = iBillsRepository.findAllByUser_Id(id);
        if (bills != null) {
            if (Objects.equals(bills.getStatus(), "2")) {
                return bills;
            } else {
                Bills bills1 = new Bills();
                User user = iUserService.findOne(id);
                bills1.setUser(user);
                return iBillsRepository.save(bills1);
            }
        } else {
            Bills bills1 = new Bills();
            User user = iUserService.findOne(id);
            bills1.setUser(user);
            return iBillsRepository.save(bills1);
        }

    }

    @Override
    public Bills findByShops_Id(Long id) {
        return iBillsRepository.findByShopIdStatus(id);
    }

    @Override
    public Bills findByProductsCartId(Long id) {
        return iBillsRepository.findByProductsCartId(id);
    }


}
