package com.sipBaskets.SIPBaskets.repository;

import com.sipBaskets.SIPBaskets.entity.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {

    //Stock findStockByName(String name);
    Stock findByName(String name);
    void deleteStockByName(String name);

}
