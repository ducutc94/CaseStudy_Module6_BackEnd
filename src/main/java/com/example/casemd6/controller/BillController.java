package com.example.casemd6.controller;

import com.example.casemd6.model.Bills;
import com.example.casemd6.service.IBillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bills")
public class BillController {
    @Autowired
    private IBillsService iBillsService;

    @GetMapping()
    public ResponseEntity<List<Bills>> findAll() {
        List<Bills> billsList = (List<Bills>) iBillsService.findAll();
        if (billsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(billsList, HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/shop/{id}")
    public ResponseEntity<List<Bills>> findAll(@PathVariable Long id) {
        List<Bills> billsList = (List<Bills>) iBillsService.findAllByStatus(id);
        if (billsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(billsList, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Bills>> findOne(@PathVariable Long id) {
        Optional<Bills> billsOptional = iBillsService.findOne(id);
        if (!billsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(billsOptional, HttpStatus.OK);
        }
    }

    @PostMapping
    public  ResponseEntity<Bills> create(@RequestBody Bills bills) {
        return new ResponseEntity<>(iBillsService.save(bills), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Bills>> update(@PathVariable Long id, @RequestBody Bills bills) {
        Optional<Bills> billsOptional = iBillsService.findOne(id);
        if (!billsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            bills.setId(id);
            iBillsService.save(bills);
            return new ResponseEntity<>(billsOptional, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Optional<Bills>> delete(@PathVariable Long id) {
        Optional<Bills> billsOptional = iBillsService.findOne(id);
        if (!billsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            iBillsService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
