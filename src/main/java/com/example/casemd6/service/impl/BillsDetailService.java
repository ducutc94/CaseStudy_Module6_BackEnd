package com.example.casemd6.service.impl;

import com.example.casemd6.model.BillsDetail;
import com.example.casemd6.service.IBillsDetailService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillsDetailService implements IBillsDetailService {
    @Override
    public Iterable<BillsDetail> findAll() {
        return null;
    }

    @Override
    public Optional<BillsDetail> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public BillsDetail save(BillsDetail billsDetail) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
