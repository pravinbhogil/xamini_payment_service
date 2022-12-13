package com.cognizant.payments.payments.publisher;


import com.cognizant.payments.payments.Account;

public class PaymentNotificationServiceDefault implements PaymentNotificationService{
    @Override
    public void pay(Account account, double payment) {
        System.out.printf("Account ["+account.getName()+"] customer ["+ account.getCustomer().getName()+"] payment=["+payment+"]" );
        System.out.println();
    }
}
