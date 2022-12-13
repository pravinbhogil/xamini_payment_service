package com.cognizant.payments.payments;

import com.cognizant.payments.entity.Account;

public interface PaymentService {


     void processPayment(Account account, double amount, int salesUnits );
}
