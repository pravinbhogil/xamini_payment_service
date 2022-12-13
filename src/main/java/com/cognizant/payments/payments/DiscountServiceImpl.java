package com.cognizant.payments.payments;

public class DiscountServiceImpl  implements DiscountService{
    @Override
    public double promotionDischarge( double amount, int salesUnits ) {
        double discount = 0.0;
        if (amount >= 100.0) {
            if (salesUnits >= 100)
                return discount = 9.95 / 100;

            if (salesUnits >= 50)
                return discount = 4.95 / 100;
        }
        return discount;
    }

    }
