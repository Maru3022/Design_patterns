package com.example.patterns.builder;

public class Laptop {
    private final String processor;
    private final int ram;
    private final boolean hasSsd;

    public Laptop(Builder builder) {
        this.processor = builder.getProcessor();
        this.ram = builder.getRam();
        this.hasSsd = builder.isHasSsd();
    }

    @Override
    public String toString() {
        return "Laptop [CPU=" + processor + ", RAM=" + ram + "GB, SSD=" + hasSsd + "]";
    }
}
