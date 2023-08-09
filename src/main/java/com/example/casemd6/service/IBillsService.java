package com.example.casemd6.service;

import com.example.casemd6.model.Bills;

import java.util.List;

public interface IBillsService extends IGeneralService<Bills>{
    List<Bills> findAllByStatus(Long id);
}
