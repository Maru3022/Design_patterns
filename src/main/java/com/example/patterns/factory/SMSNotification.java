package com.example.patterns.factory;

public class SMSNotification implements Notification {
    @Override
    public void notifyUser(){
        System.out.println("Sending SMS alert to the client...");
    }
}
