package com.example.patterns.chain;

public abstract class Handler {
    private Handler next;

    public static Handler link(Handler first, Handler... chain){
        Handler head = first;
        for(Handler nextInChain : chain){
            head.next = nextInChain;
            head = nextInChain;
        }

        return first;
    }

    public abstract boolean check(String data);

    protected boolean checkNext(String data){
        if(next == null) return true;
        return next.check(data);
    }
}
