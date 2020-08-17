package com.avajlauncher.simulator.aircraft;

import com.avajlauncher.simulator.WeatherTower;
import com.avajlauncher.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
//        calls weather
    }

    public void registerTower(WeatherTower weatherTower) {
        System.out.println("Tower says: Helicopter#" + super.name + "(" + super.id + ")" + "registered to weather tower");
    }
}