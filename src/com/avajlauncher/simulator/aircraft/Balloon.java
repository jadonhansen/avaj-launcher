package com.avajlauncher.simulator.aircraft;

import com.avajlauncher.simulator.WeatherTower;
import com.avajlauncher.weather.Coordinates;

public class Balloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);

        switch (currentWeather) {
            case "RAIN":
                if ((this.coordinates.getHeight() - 5) <= 0) {
                    this.reportLanding("Balloon");
                    this.weatherTower.unregister(this);
                } else {
                    this.missionReport("Balloon", "RAIN");
                    this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
                }
                break;
            case "FOG":
                if ((this.coordinates.getHeight() - 3) <= 0) {
                    this.reportLanding("Balloon");
                    this.weatherTower.unregister(this);
                } else {
                    this.missionReport("Balloon", "FOG");
                    this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
                }
                break;
            case "SUN":
                if ((this.coordinates.getHeight() + 4) >= 100) {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), 100);
                } else {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
                }
                this.missionReport("Balloon", "SUN");
                break;
            case "SNOW":
                if ((this.coordinates.getHeight() - 15) <= 0) {
                    this.reportLanding("Balloon");
                    this.weatherTower.unregister(this);
                } else {
                    this.missionReport("Balloon", "SNOW");
                    this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
                }
                break;
            default:
                System.out.println("Unknown weather condition encountered: '" + currentWeather + "'.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.saveReport("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " registered to weather tower\n");
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}