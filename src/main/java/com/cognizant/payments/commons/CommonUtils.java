package com.cognizant.payments.commons;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommonUtils {

    private CommonUtils(){

    }

    public static double round(double payment) {
        BigDecimal paymentAfterRounding = BigDecimal.valueOf(payment);
        paymentAfterRounding = paymentAfterRounding.setScale(2, RoundingMode.HALF_UP);
        return paymentAfterRounding.doubleValue();
    }
}
