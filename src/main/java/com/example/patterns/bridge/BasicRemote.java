package com.example.patterns.bridge;

public class BasicRemote extends RemoteControl{
    public BasicRemote(Device device){
        super(device);
    }

    @Override
    public void togglePower(){
        System.out.println("RemoteControl: Power button pressed.");
        device.turnOn();
    }
}
