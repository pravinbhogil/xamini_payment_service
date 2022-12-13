package com.cognizant.payments.payments.publisher;


import com.cognizant.payments.entity.Customer;
import com.cognizant.payments.entity.Membership;


public class CustomerNotificationServiceDefault implements CustomerNotificationService
{
    @Override
    public void membershipChange(Customer customer, Membership oldLabel, Membership newLabel) {
        System.out.println("notify customer ["+customer.getName()+"] membership moving from ["+oldLabel+"] to ["+newLabel+"]");

    }
}
