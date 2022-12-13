package com.cognizant.payments.payments.publisher;


import com.cognizant.payments.entity.Account;

public class PaymentNotificationServiceDefault implements PaymentNotificationService{
    @Override
    public void pay(Account account, double payment) {
        System.out.println("Account ["+account.getName()+"] customer ["+ account.getCustomer().getName()+"] payment=["+payment+"]" );

    }
}
