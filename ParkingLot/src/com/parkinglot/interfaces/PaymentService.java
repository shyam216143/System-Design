package com.parkinglot.interfaces;

public interface PaymentService {
    void acceptCash(int amount);
    void acceptCredit(String cardNumber, int cvv, int amount);

}
