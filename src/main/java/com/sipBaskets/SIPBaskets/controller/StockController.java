package com.sipBaskets.SIPBaskets.controller;

import com.sipBaskets.SIPBaskets.entity.Stock;
import com.sipBaskets.SIPBaskets.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @PostMapping("/addStock")
    void addStock(@RequestBody Stock stock){
        stockRepository.save(stock);
    }

    @GetMapping("/displayStock")
    List<Stock> displayStock(){
        return (List<Stock>) stockRepository.findAll();
    }

    @PostMapping("/currentPrice")
    ResponseEntity<Stock> currentPrice(@RequestBody String name) {
        try {
            return new ResponseEntity((stockRepository.findByName("META").getPrice()), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
