package com.cognizant.payments.payments.publisher;


import com.cognizant.payments.payments.Account;

public interface PaymentNotificationService {
    void pay(Account account, double payment);
}
