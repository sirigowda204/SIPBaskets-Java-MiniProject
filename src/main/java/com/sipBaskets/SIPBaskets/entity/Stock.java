package com.sipBaskets.SIPBaskets.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private String company;
}
