package com.example.casemd6.service.impl;

import com.example.casemd6.model.Bills;
import com.example.casemd6.repository.IBillsRepository;
import com.example.casemd6.service.IBillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillsService implements IBillsService {
    @Autowired
    private IBillsRepository iBillsRepository;
    @Override
    public Iterable<Bills> findAll() {
        return iBillsRepository.findAll();
    }

    @Override
    public List<Bills> findAllByStatus(Long id) {
        return iBillsRepository.findAllStatus(id);
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
        Optional<Bills> billsOptional = iBillsRepository.findById(id);
        if (billsOptional.isPresent()){
            billsOptional.get().setStatusBills("1");
            iBillsRepository.save(billsOptional.get());
        }
    }
}
