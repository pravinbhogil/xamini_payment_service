package com.cognizant.payments.payments.publisher;


import com.cognizant.payments.payments.Customer;
import com.cognizant.payments.payments.Membership;


public interface CustomerNotificationService {

    void membershipChange(Customer customer, Membership oldLabel, Membership newLabel);

}
