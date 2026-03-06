package com.example.patterns.factory;

 public class SMSFactory extends NotificationFactory{
     @Override
     public Notification createNotification(){
        return new SMSNotification();
    }
}
