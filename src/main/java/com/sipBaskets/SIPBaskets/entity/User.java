package com.sipBaskets.SIPBaskets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    int id;
    String userName;
    String bankAccount;
    Long balance;
    @ManyToOne
    @JoinColumn(name = "stock_id")
    Stock stock;



}
