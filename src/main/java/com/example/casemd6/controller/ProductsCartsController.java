package com.example.casemd6.controller;

import com.example.casemd6.model.Products;
import com.example.casemd6.model.ProductsCarts;
import com.example.casemd6.service.IProductsCartsService;
import com.example.casemd6.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products-carts")
public class ProductsCartsController {
    @Autowired
    private IProductsCartsService iProductsCartsService;
    @Autowired
    private IProductsService iProductsService;
    @GetMapping()
    public ResponseEntity<List<ProductsCarts>> findAll() {
        List<ProductsCarts> productsCartsList = (List<ProductsCarts>) iProductsCartsService.findAll();
        if (productsCartsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productsCartsList, HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductsCarts>> findOne(@PathVariable Long id) {
        Optional<ProductsCarts> productsCartsOptional = iProductsCartsService.findOne(id);
        if (!productsCartsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productsCartsOptional, HttpStatus.OK);
        }
    }
    @PostMapping
    public  ResponseEntity<ProductsCarts> create(@RequestBody ProductsCarts productsCarts) {
        return new ResponseEntity<>(iProductsCartsService.save(productsCarts), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductsCarts> update(@PathVariable Long id, @RequestBody ProductsCarts productsCarts) {
        Optional<ProductsCarts> productsCartsOptional = iProductsCartsService.findOne(id);
        if (!productsCartsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            productsCarts.setId(id);
            productsCarts.setStatusProductsCarts("0");
            iProductsCartsService.save(productsCarts);
            return new ResponseEntity<>(productsCarts, HttpStatus.OK);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductsCarts> updateStatus(@PathVariable Long id) {
        Optional<ProductsCarts> productsCartsOptional = iProductsCartsService.findOne(id);
        ProductsCarts productsCarts = productsCartsOptional.get();
        productsCarts.setStatusProductsCarts("5");
        iProductsCartsService.update(productsCarts);
        return new ResponseEntity<>(productsCarts, HttpStatus.OK);
    }
    @PutMapping("/update-confirm/{id}")
    public ResponseEntity<ProductsCarts> updateConfirm(@PathVariable Long id) {
        Optional<ProductsCarts> productsCartsOptional = iProductsCartsService.findOne(id);
        ProductsCarts productsCarts = productsCartsOptional.get();
        Products products = iProductsService.findOne(productsCarts.getProducts().getId()).get();
        products.setQuantity(products.getQuantity()-productsCarts.getQuantity());
        productsCarts.setStatusProductsCarts("0");
        iProductsService.save(products);
        iProductsCartsService.update(productsCarts);
        return new ResponseEntity<>(productsCarts, HttpStatus.OK);
    }
    @PutMapping("/merchant-update/{id}")
    public ResponseEntity<ProductsCarts> merchantUpdate(@PathVariable Long id) {
        Optional<ProductsCarts> productsCartsOptional = iProductsCartsService.findOne(id);
        ProductsCarts productsCarts = productsCartsOptional.get();
        productsCarts.setStatusProductsCarts("0");
        iProductsCartsService.update(productsCarts);
        return new ResponseEntity<>(productsCarts, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<ProductsCarts> productsCartsOptional = iProductsCartsService.findOne(id);
        if (!productsCartsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            iProductsCartsService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/merchant/{id}")
    ResponseEntity<Void> deleteM(@PathVariable Long id) {
        Optional<ProductsCarts> productsCartsOptional = iProductsCartsService.findOne(id);
        if (!productsCartsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            iProductsCartsService.deleteM(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<ProductsCarts>> findAllById(@PathVariable Long id) {
        List<ProductsCarts> productsCartsList = iProductsCartsService.findByIdUser(id);
        if (productsCartsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productsCartsList, HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/user-cart/{id}")
    public ResponseEntity<List<ProductsCarts>> findAllByIdUser(@PathVariable Long id) {
        List<ProductsCarts> productsCartsList = iProductsCartsService.findByIdUserCart(id);
        if (productsCartsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productsCartsList, HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/merchant-cart/{id}")
    public ResponseEntity<List<ProductsCarts>> findAllByIdMerchant(@PathVariable Long id) {
        List<ProductsCarts> productsCartsList = iProductsCartsService.findByIdMerchant(id);
        if (productsCartsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productsCartsList, HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/merchant-service/{id}")
    public ResponseEntity<List<ProductsCarts>> findByIdMerchantService(@PathVariable Long id) {
        List<ProductsCarts> productsCartsList = iProductsCartsService.findByIdMerchantService(id);
        if (productsCartsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productsCartsList, HttpStatus.ACCEPTED);
        }
    }

}
