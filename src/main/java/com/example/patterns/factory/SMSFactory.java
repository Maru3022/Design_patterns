package com.example.patterns.factory;

 class SMSFactory extends NotificationFactory{
    public Notification createNotification(){
        return new EmailNotification();
    }
}
