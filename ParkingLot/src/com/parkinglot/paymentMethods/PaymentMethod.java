package com.parkinglot.paymentMethods;

public abstract class PaymentMethod {
    public abstract boolean initiatePayment(int amount);
}
