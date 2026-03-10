package com.example.patterns.bridge;

public class Radio implements Device{
    @Override
    public void turnOn(){
        System.out.println("Radio: Device is now ON.");
    }
}
