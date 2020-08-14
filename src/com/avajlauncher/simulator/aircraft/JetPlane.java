package com.avajlauncher.simulator.aircraft;

import com.avajlauncher.simulator.Tower;
import com.avajlauncher.simulator.WeatherTower;
import com.avajlauncher.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register();

//        below goes inside tower.java?
        System.out.println("Tower says: JetPlane#" + super.name + "(" + super.id + ")" + "registered to weather tower");
    }
}