package com.cognizant.payments.payments.publisher;


import com.cognizant.payments.payments.Customer;
import com.cognizant.payments.payments.Membership;


public class CustomerNotificationServiceDefault implements CustomerNotificationService
{
    @Override
    public void membershipChange(Customer customer, Membership oldLabel, Membership newLabel) {
        System.out.printf("notify customer ["+customer.getName()+"] membership moving from ["+oldLabel+"] to ["+newLabel+"]");
        System.out.println();
    }
}
