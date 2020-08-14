package com.avajlauncher.simulator.aircraft;

interface Flyable {

    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);
}