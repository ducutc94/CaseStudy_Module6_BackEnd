package com.example.casemd6.service.impl;

import com.example.casemd6.model.Bills;
import com.example.casemd6.service.IBillsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillsService implements IBillsService {
    @Override
    public Iterable<Bills> findAll() {
        return null;
    }

    @Override
    public Optional<Bills> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Bills save(Bills bills) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
