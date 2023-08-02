package com.example.casemd6.service.impl;

import com.example.casemd6.model.Shops;
import com.example.casemd6.service.IShopsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopsService implements IShopsService {
    @Override
    public Iterable<Shops> findAll() {
        return null;
    }

    @Override
    public Optional<Shops> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Shops save(Shops shops) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
