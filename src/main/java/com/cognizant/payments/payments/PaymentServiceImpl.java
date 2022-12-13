package com.cognizant.payments.payments;

import com.cognizant.payments.payments.publisher.CustomerNotificationService;
import com.cognizant.payments.payments.publisher.PaymentNotificationService;
import lombok.var;

public class PaymentServiceImpl {

	private CustomerNotificationService customerNotificationService;
	private PaymentNotificationService paymentNotificationService;

	public PaymentServiceImpl(CustomerNotificationService customerNotificationService, PaymentNotificationService paymentNotificationService) {
		this.customerNotificationService = customerNotificationService;
		this.paymentNotificationService = paymentNotificationService;
	}

	public String getServiceName() {
		return  this.getClass().getSimpleName();
	}

	public void processPayment(Account account, double amount, int salesUnits ) {

		double payment = CommonUtils.round(amount * salesUnits * (1.0 - promotionDischarge(amount, salesUnits)));

		account.setBalance( account.getBalance() - payment );

		paymentNotificationService.pay(account, payment);

		var oldMembership = account.getMembership();
		var newMembership = checkMembership(account);
		if ( newMembership != oldMembership) {
			customerNotificationService.membershipChange(account.getCustomer(), oldMembership, newMembership);
		}

	}

	private double promotionDischarge( double amount, int salesUnits ) {
		double discount = 0.0;
		if ( amount >= 100.0 ) {
			if ( salesUnits >= 100) {
				discount = 9.95/ 100;
			}
			else if ( salesUnits >= 50) {
				discount = 4.95 / 100;
			}
		}
		return discount;
	}

	private Membership checkMembership( Account account )
	{
		if ( account.getBalance() > 50_000)
			return Membership.SILVER;
		if ( account.getBalance() > 250_000)
			return Membership.GOLD;
		return Membership.BRONZE;
	}

}

