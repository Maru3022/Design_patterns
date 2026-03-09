package com.example.patterns.observer;

public class DeliveryService implements Observer{
    @Override
    public void update(String status){
        if(status.equals("READY_FOR_SHIPPING")){
            System.out.println("[Delivery Service] Logistics alert: Courier has been notified for pickup");
        }else{
            System.out.println("[Delivery Service] System log: Order status updated to " + status);
        }
    }
}
