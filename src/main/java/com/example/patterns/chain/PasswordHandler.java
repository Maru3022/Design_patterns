package com.example.patterns.chain;

public class PasswordHandler extends Handler{
    @Override
    public boolean check(String data){
        if(data.endsWith("_12345")){
            System.out.println("AuthChain: password verification successful");
            return checkNext(data);
        }

        System.out.println("AuthChain: Invalid password provided");
        return false;
    }
}
