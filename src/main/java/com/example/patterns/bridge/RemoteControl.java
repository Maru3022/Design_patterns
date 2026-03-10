package com.example.patterns.bridge;

public abstract class RemoteControl {
    protected Device device;
    protected RemoteControl(Device device){
        this.device = device;
    }

    public abstract void togglePower();
}
