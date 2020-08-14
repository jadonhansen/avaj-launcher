package com.avajlauncher.weather;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private WeatherProvider() {
//        creates and stores current weather
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
//        returns current weather at specific coordinates
    }
}