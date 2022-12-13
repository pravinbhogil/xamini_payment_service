package com.cognizant.payments.payments;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;
@Data
@AllArgsConstructor
public class Account {
    private int id;

    private String name;
    private Customer customer;
    private double balance;
    private Membership membership;


}
