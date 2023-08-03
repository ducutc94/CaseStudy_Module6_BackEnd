package com.example.casemd6.service.impl;

import com.example.casemd6.model.Shops;
import com.example.casemd6.repository.IShopsRepository;
import com.example.casemd6.service.IShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopsService implements IShopsService {
    @Autowired
    private IShopsRepository iShopsRepository;
    List<Shops> shopsList;

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
            iShopsRepository.save(shops);
        }
    }

    @Override
    public List<Shops> findShopByUserId(Long id) {
        return iShopsRepository.findShopByUserId(id);
    }
}
