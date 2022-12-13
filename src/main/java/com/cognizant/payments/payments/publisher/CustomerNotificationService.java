package com.cognizant.payments.payments.publisher;


import com.cognizant.payments.entity.Customer;
import com.cognizant.payments.entity.Membership;


public interface CustomerNotificationService {

    void membershipChange(Customer customer, Membership oldLabel, Membership newLabel);

}
