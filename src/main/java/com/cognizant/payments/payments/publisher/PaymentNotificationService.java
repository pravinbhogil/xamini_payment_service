package com.cognizant.payments.payments.publisher;


import com.cognizant.payments.entity.Account;

public interface PaymentNotificationService {
    void pay(Account account, double payment);
}
