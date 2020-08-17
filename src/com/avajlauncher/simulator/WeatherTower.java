package com.avajlauncher.simulator;

import com.avajlauncher.weather.Coordinates;
import com.avajlauncher.weather.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}