package com.cognizant.payments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private int id;

    private String name;
    private Customer customer;
    private double balance;
    private Membership membership;


    public Membership checkMembership(Account account )
    {
        if ( account.getBalance() > 50_000)
            return Membership.SILVER;
        if ( account.getBalance() > 250_000)
            return Membership.GOLD;
        return Membership.BRONZE;
    }


}
