package com.example.patterns.observer;

public class EmailNotificationService implements Observer{
    @Override
    public void update(String status){
        System.out.println("[Email Service] Sending notification: Your order is now " + status);
    }
}
