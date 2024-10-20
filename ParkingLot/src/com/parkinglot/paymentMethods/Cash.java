package com.parkinglot.paymentMethods;

public class Cash extends PaymentMethod {
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("Initiating payment is "+amount);
        return true;
    }
}
