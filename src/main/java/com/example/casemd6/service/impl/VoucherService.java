package com.example.casemd6.service.impl;

import com.example.casemd6.model.Voucher;
import com.example.casemd6.repository.IVoucherRepository;
import com.example.casemd6.service.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherService implements IVoucherService {
    @Autowired
    private IVoucherRepository iVoucherRepository;
    @Override
    public Iterable<Voucher> findAll() {
        return iVoucherRepository.findAll();
    }

    @Override
    public List<Voucher> findAllByShop(Long id) {
        return iVoucherRepository.findAllByShop(id);
    }

    @Override
    public Optional<Voucher> findOne(Long id) {
        return iVoucherRepository.findById(id);
    }

    @Override
    public Voucher save(Voucher voucher) {
        return iVoucherRepository.save(voucher);
    }


    @Override
    public void remove(Long id) {
        Optional<Voucher> voucherOptional = iVoucherRepository.findById(id);
        if (voucherOptional.isPresent()){
            voucherOptional.get().setStatusVoucher("1");
            iVoucherRepository.save(voucherOptional.get());
        }
    }
}
