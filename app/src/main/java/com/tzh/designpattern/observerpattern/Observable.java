package com.tzh.designpattern.observerpattern;

import java.util.ArrayList;

/**
 * create by tuzanhua on 2020/4/26
 */
public class Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    public void registObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void remove(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    public void notifyDataChanged(String data) {
        for (Observer observer : observers) {
            observer.updateData(data);
        }
    }

}
