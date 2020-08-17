package com.avajlauncher.weather;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private WeatherProvider() {
        weather[0] = "RAIN";
        weather[1] = "FOG";
        weather[2] = "SUN";
        weather[3] = "SNOW";
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return "SUN";
    }
}