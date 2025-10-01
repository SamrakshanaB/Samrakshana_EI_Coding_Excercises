
package com.example.designpatterns.behavioural.observer;

public interface Stock {
    void registerObserver(Investor investor);
    void removeObserver(Investor investor);
    void notifyObservers();
}
