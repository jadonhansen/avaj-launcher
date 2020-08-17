package com.avajlauncher.simulator.aircraft;

import com.avajlauncher.simulator.WeatherTower;
import com.avajlauncher.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);

        switch (currentWeather) {
            case "RAIN":
                this.missionReport("Helicopter", "RAIN");
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
                break;
            case "FOG":
                this.missionReport("Helicopter", "FOG");
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
                break;
            case "SUN":
                if (this.coordinates.getHeight() + 2 >= 100) {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), 100);
                } else {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
                }
                this.missionReport("Helicopter", "SUN");
                break;
            case "SNOW":
                if ((this.coordinates.getHeight() - 12) <= 0)  {
                    this.reportLanding("Helicopter");
                    this.weatherTower.unregister(this);
                } else {
                    this.missionReport("Helicopter", "SNOW");
                    this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
                }
                break;
            default:
                System.out.println("Unknown weather condition encountered: '" + currentWeather + "'.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower");
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}