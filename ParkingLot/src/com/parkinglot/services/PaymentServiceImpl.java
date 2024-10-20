package com.parkinglot.services;

import com.parkinglot.interfaces.PaymentService;
import com.parkinglot.paymentMethods.Cash;
import com.parkinglot.paymentMethods.CreditCard;
import com.parkinglot.paymentMethods.PaymentMethod;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public void acceptCash(int amount) {
        PaymentMethod cash = new Cash();
        cash.initiatePayment(amount);
    }

    @Override
    public void acceptCredit(String cardNumber, int cvv, int amount) {
        PaymentMethod credit_card = new CreditCard(cardNumber, cvv);
        credit_card.initiatePayment(amount);
    }
}
