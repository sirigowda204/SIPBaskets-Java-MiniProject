package com.sipBaskets.SIPBaskets.service;

import com.sipBaskets.SIPBaskets.entity.Stock;
import com.sipBaskets.SIPBaskets.entity.User;
import com.sipBaskets.SIPBaskets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundService {

    @Autowired
    UserRepository userRepository;

    void addBank(User user){
        User userTemp = userRepository.findByUserName(user.getUserName());
        userTemp.setBankAccount(user.getBankAccount());
        userRepository.save(userTemp);
    }

    void transferToBank(User user){
        User userTemp = userRepository.findByUserName(user.getUserName());
        userTemp.setBalance(user.getBalance());
        userRepository.save(userTemp);
    }

    void transferFromBank(User user, long amount){
        User userTemp = userRepository.findByUserName(user.getUserName());
        userTemp.setBalance(user.getBalance()-amount);
        userRepository.save(userTemp);
    }

    Long checkWalletBalance(String name){
        return (userRepository.findByUserName(name)).getBalance();
    }

    Stock checkPortfolio(String name){
        return (userRepository.findByUserName(name)).getStock();
    }
}
