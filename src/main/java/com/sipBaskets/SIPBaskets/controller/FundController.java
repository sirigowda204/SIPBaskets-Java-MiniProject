package com.sipBaskets.SIPBaskets.controller;

import com.sipBaskets.SIPBaskets.entity.Stock;
import com.sipBaskets.SIPBaskets.entity.Users;
import com.sipBaskets.SIPBaskets.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundController {

    @Autowired
    FundService fundService;

    @PostMapping("/addBank")
    String addBank(@RequestBody Users users) {
        fundService.addBank(users);
        return "Bank Added";

    }

    @PostMapping("/transferToBank")
    String transferToBank(@RequestBody Users users){
        fundService.transferToBank(users);
        return "amount transferred";

    }

    @PostMapping("/transferFromBank")
    String transferFromBank(@RequestBody Users users, double amount){
        fundService.transferFromBank(users,amount);
        return "amount withdrawn";
    }

    @GetMapping("/checkWalletBalance")
    Double checkWalletBalance(@RequestBody String userName){
        return fundService.checkWalletBalance(userName);

    }

    @GetMapping("/checkPortfolio")
    Stock checkPortfolio(@RequestBody String name){
        return fundService.checkPortfolio(name);
    }

}
