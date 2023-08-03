package com.example.casemd6.controller;

import com.example.casemd6.model.Shops;
import com.example.casemd6.service.IShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    private IShopsService iShopsService;

    @GetMapping
    public ResponseEntity<List<Shops>> findAll() {
        List<Shops> shopsList = (List<Shops>) iShopsService.findAll();
        if (shopsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(shopsList, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Shops>> findShopByUserId(@PathVariable Long id) {
        List<Shops> shopsList =  iShopsService.findShopByUserId(id);
        if (shopsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(shopsList, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Shops>> findOne(@PathVariable Long id) {
        Optional<Shops> shopsOptional = iShopsService.findOne(id);
        if (!shopsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(shopsOptional, HttpStatus.OK);
        }
    }

    @PostMapping
    public  ResponseEntity<Shops> create(@RequestBody Shops shops) {
        return new ResponseEntity<>(iShopsService.save(shops), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Shops>> update(@PathVariable Long id, @RequestBody Shops shops) {
        Optional<Shops> shopsOptional = iShopsService.findOne(id);
        if (!shopsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            shops.setId(id);
            iShopsService.save(shops);
            return new ResponseEntity<>(shopsOptional, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Optional<Shops>> delete(@PathVariable Long id) {
        Optional<Shops> shopsOptional = iShopsService.findOne(id);
        if (!shopsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            iShopsService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
