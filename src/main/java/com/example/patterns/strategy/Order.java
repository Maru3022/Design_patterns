package com.example.patterns.strategy;

public class Order {
    private double amount;
    private PaymentStrategy paymentStrategy;

    public Order(double amount) {
        this.amount = amount;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processOrder() {
        if (paymentStrategy == null) {
            System.out.println("Error: Payment method not selected!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}