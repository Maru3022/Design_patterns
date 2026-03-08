package com.example.patterns.builder;

public class Builder {
    private String processor;
    private int ram = 8;
    private boolean hasSsd = false;

    public Builder(String processor){
        this.processor = processor;
    }

    public Builder setRam(int ram){
        this.ram = ram;
        return this;
    }

    public Builder setHasSsd(boolean hasSsd){
        this.hasSsd = hasSsd;
        return this;
    }

    public Laptop build(){
        return new Laptop(this);
    }

    public String getProcessor() { return processor; }
    public int getRam() { return ram; }
    public boolean isHasSsd() { return hasSsd; }
}
