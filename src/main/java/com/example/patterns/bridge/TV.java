package com.example.patterns.bridge;

public class TV implements Device{
    @Override
    public void turnOn(){
        System.out.println("TV: Screen is powered ON.");
    }
}
