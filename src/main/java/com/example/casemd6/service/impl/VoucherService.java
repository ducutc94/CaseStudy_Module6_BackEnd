package com.example.casemd6.service.impl;

import com.example.casemd6.model.Voucher;
import com.example.casemd6.service.IVoucherService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoucherService implements IVoucherService {
    @Override
    public Iterable<Voucher> findAll() {
        return null;
    }

    @Override
    public Optional<Voucher> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Voucher save(Voucher voucher) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
