package com.avajlauncher.simulator;

import com.avajlauncher.simulator.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {

    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> landed = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        landed.add(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable observer: observers) {
            observer.updateConditions();
        }
        observers.removeAll(landed);
    }
}