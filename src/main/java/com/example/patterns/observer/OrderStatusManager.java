package com.example.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusManager {
    private List<Observer> observers = new ArrayList<>();
    private String status;

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void setStatus(String status){
        this.status = status;
        System.out.println("[Subject] Order status changed to: " + status);
        notifyObservers();
    }

    private void notifyObservers(){
        for(Observer observer : observers){
            observer.update(status);
        }
    }
}
