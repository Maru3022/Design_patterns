package com.example.patterns.chain;

public class UserExistsHandler extends Handler{
    @Override
    public boolean check(String data){
        if(data.startsWith("admin")){
            System.out.println("AuthChain: User found in the system.");
            return checkNext(data);
        }
        System.out.println("AuthChain: User NOT found");
        return false;
    }
}
