package com.example.designpatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Investor> investors = new ArrayList<>();
    private double price;

    @Override
    public void registerObserver(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void removeObserver(Investor investor) {
        investors.remove(investor);
    }

    @Override
    public void notifyObservers() {
        for (Investor investor : investors) {
            investor.update(price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}
