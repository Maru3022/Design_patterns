package com.example.patterns.adapter;

import tools.jackson.databind.ext.javatime.deser.key.OffsetTimeKeyDeserializer;

public class SocketAdapter implements UsbCCharger{
    private OldEuropeanSocket oldSocket;

    public SocketAdapter(OldEuropeanSocket oldSocket){
        this.oldSocket = oldSocket;
    }

    @Override
    public void charge(){
        System.out.println("[Адаптер]: Преобразует 220V в 5V USB-C...");
        oldSocket.givePowerViaTwoPins();
        System.out.println("[Адаптер]: Зарядка пошла успешно!");
    }
}
