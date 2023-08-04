package com.example.casemd6.controller;


import com.example.casemd6.model.Products;
import com.example.casemd6.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    private IProductsService productService;

    @GetMapping
    public ResponseEntity<Iterable<Products>> showProductAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Products>> findOneProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findOne(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Products> createProducts(@RequestBody Products products) {
        productService.save(products);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products p) {
        Optional<Products> studentOptional = productService.findOne(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        p.setId(id);
        productService.save(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Products>> deleteProduct(@PathVariable Long id) {
        Optional<Products> student = productService.findOne(id);
        if (student.isPresent()) {
            productService.remove(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Products>> findProductByName(@RequestParam("search") String search) {
        List<Products> productsList = productService.findAllByName(search);
        if (productsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productsList, HttpStatus.OK);
        }
    }
}
