package com.example.casemd6.service.impl;

import com.example.casemd6.model.City;
import com.example.casemd6.service.ICityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Override
    public Iterable<City> findAll() {
        return null;
    }

    @Override
    public Optional<City> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public City save(City city) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
