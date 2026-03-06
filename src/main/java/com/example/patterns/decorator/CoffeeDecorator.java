package com.example.patterns.decorator;

public abstract class CoffeeDecorator implements Coffee{
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee = coffee;
    }

    public String getDescription(){
        return decoratedCoffee.getDescription();
    }

    public double getCost(){
        return decoratedCoffee.getCost();
    }
}
