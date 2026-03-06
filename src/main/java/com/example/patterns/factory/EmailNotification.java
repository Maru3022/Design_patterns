package com.example.patterns.factory;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("Dispatching Email notification...");
    }
}
