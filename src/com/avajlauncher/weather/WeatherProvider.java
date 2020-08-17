package com.avajlauncher.weather;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        if (height <= 20) {
                return weather[2];
        } else if (height <= 40) {

            if (longitude <= 25) {
                if (latitude <= 25) {
                    return weather[0];
                } else {
                    return weather[3];
                }
            } else {
                if (latitude <= 25) {
                    return weather[3];
                } else {
                    return weather[0];
                }
            }

        } else {
            return weather[1];
        }
    }
}