package com.cognizant.payments.payments;

import com.cognizant.payments.commons.CommonUtils;
import com.cognizant.payments.entity.Account;
import com.cognizant.payments.entity.Membership;
import com.cognizant.payments.payments.publisher.CustomerNotificationService;
import com.cognizant.payments.payments.publisher.PaymentNotificationService;

public class PaymentServiceImpl implements PaymentService{

	private CustomerNotificationService customerNotificationService;
	private PaymentNotificationService paymentNotificationService;
	private DiscountService discountService;

	public PaymentServiceImpl(CustomerNotificationService customerNotificationService, PaymentNotificationService paymentNotificationService,DiscountService discountService) {
		this.customerNotificationService = customerNotificationService;
		this.paymentNotificationService = paymentNotificationService;
		this.discountService=discountService;
	}


	public void processPayment(Account account, double amount, int salesUnits ) {

		double payment = CommonUtils.round(amount * salesUnits * (1.0 - discountService.promotionDischarge(amount, salesUnits)));

		account.setBalance( account.getBalance() - payment );

		paymentNotificationService.pay(account, payment);

		var oldMembership = account.getMembership();
		var newMembership = account.checkMembership(account);
		if ( newMembership != oldMembership) {
			customerNotificationService.membershipChange(account.getCustomer(), oldMembership, newMembership);
		}

	}





}

