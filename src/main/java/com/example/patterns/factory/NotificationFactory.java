package com.example.patterns.factory;

abstract class NotificationFactory {
    public abstract Notification createNotification();

    public void send() {
        Notification n = createNotification();
        n.notifyUser();
    }
}