package com.example.casemd6.service.impl;

import com.example.casemd6.model.Shops;
import com.example.casemd6.repository.IShopsRepository;
import com.example.casemd6.service.IProductsService;
import com.example.casemd6.service.IShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ShopsService implements IShopsService {
    @Autowired
    private IShopsRepository iShopsRepository;
    @Autowired
    private IProductsService iProductsService;
    @Override
    public Iterable<Shops> findAll() {
        return iShopsRepository.findAllStatus();
    }

    @Override
    public Optional<Shops> findOne(Long id) {
        return iShopsRepository.findOneStatus(id);
    }

    @Override
    public Shops save(Shops shops) {
        return iShopsRepository.save(shops);
    }

    @Override
    public void remove(Long id) {
        Shops shops = iShopsRepository.findById(id).get();
        if (shops != null) {
            shops.setStatusShops("1");
            iProductsService.findAllByShopId(id);
            iShopsRepository.save(shops);
        }
    }

    @Override
    public List<Shops> findShopByUserId(Long id) {
        return iShopsRepository.findShopByUserId(id);
    }

    @Override
    public Shops findAllByEmailIgnoreCase(String email) {
        return iShopsRepository.findAllByEmailIgnoreCase(email);
    }

    @Override
    public List<Shops> findAllByAdmin() {
        return iShopsRepository.findAll();
    }

    @Override
    public List<Shops> findAllByUser(Long id) {
        return iShopsRepository.findAllByUser_Id(id);
    }
}
