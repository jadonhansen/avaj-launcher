package com.avajlauncher.simulator.aircraft;

import com.avajlauncher.simulator.WeatherTower;
import com.avajlauncher.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);

        switch (currentWeather) {
            case "RAIN":
                this.missionReport("JetPlane", "RAIN");
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
                break;
            case "FOG":
                this.missionReport("JetPlane", "FOG");
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
                break;
            case "SUN":
                if ((this.coordinates.getHeight() + 2) >= 100) {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, 100);
                } else {
                    this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
                }
                this.missionReport("JetPlane", "SUN");
                break;
            case "SNOW":
                if ((this.coordinates.getHeight() - 7) <= 0) {
                    this.reportLanding("JetPlane");
                    this.weatherTower.unregister(this);
                } else {
                    this.missionReport("JetPlane", "SNOW");
                    this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
                }
                break;
            default:
                System.out.println("Unknown weather condition encountered: '" + currentWeather + "'.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower");
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}