package com.sipBaskets.SIPBaskets.service;

import com.sipBaskets.SIPBaskets.entity.Stock;
import com.sipBaskets.SIPBaskets.entity.Users;
import com.sipBaskets.SIPBaskets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundService {

    @Autowired
    UserRepository userRepository;

    public void addBank(Users users){
        Users usersTemp = userRepository.findByUserName(users.getUserName());
        usersTemp.setBankAccount(users.getBankAccount());
        userRepository.save(usersTemp);
    }

    public void transferToBank(Users users){
        Users usersTemp = userRepository.findByUserName(users.getUserName());
        usersTemp.setBalance(users.getBalance());
        userRepository.save(usersTemp);
    }

    public void transferFromBank(Users users, double amount){
        Users usersTemp = userRepository.findByUserName(users.getUserName());
        usersTemp.setBalance(users.getBalance()-amount);
        userRepository.save(usersTemp);
    }

    public Double checkWalletBalance(String name){
        return (userRepository.findByUserName(name)).getBalance();
    }

    public Stock checkPortfolio(String name){
        return (userRepository.findByUserName(name)).getStock();
    }


}
