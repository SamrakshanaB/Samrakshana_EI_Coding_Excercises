package com.example.designpatterns.behavioural.observer;

public class RetailInvestor implements Investor {
    private String name;

    public RetailInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + " notified. New stock price: " + price);
    }
}
