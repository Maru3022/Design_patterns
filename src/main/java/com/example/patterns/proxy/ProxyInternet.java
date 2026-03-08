package com.example.patterns.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet{
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("facebook.com");
        bannedSites.add("instagram.com");
    }

    @Override
    public void connectTo(String serverHost){
        if(bannedSites.contains(serverHost.toLowerCase())){
            System.out.println("Access Denied to: " + serverHost);
        }else{
            internet.connectTo(serverHost);
        }
    }
}
