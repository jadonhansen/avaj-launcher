package com.avajlauncher.simulator.aircraft;

import com.avajlauncher.simulator.WeatherTower;
import com.avajlauncher.weather.Coordinates;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        Flyable object;

        switch (type) {
            case "Helicopter":
                 object = new Helicopter(name, new Coordinates(longitude, latitude, height));
                break;
            case "Balloon":
                 object =  new Balloon(name, new Coordinates(longitude, latitude, height));
                break;
            case "JetPlane":
                 object =  new JetPlane(name, new Coordinates(longitude, latitude, height));
                break;
            default:
                object = null;
                System.out.println("Unidentified flying object: '" + type + "'. Abort Mission!");
                System.exit(0);
        }
        return object;
    }
}