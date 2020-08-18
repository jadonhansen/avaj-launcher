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

        if (height <= 10) {
            if (longitude <= 20) {

                if (latitude <= 30) {
                    return weather[2];
                } else {
                    return weather[1];
                }

            } else if (longitude <= 60) {

                if (latitude <= 30) {
                    return weather[1];
                } else {
                    return weather[0];
                }

            } else {

                if (latitude <= 30) {
                    return weather[3];
                } else {
                    return weather[0];
                }

            }
        } else if (height <= 20) {
            if (longitude <= 20) {

                if (latitude <= 30) {
                    return weather[2];
                } else {
                    return weather[0];
                }

            } else if (longitude <= 60) {

                if (latitude <= 30) {
                    return weather[3];
                } else {
                    return weather[2];
                }

            } else {

                if (latitude <= 30) {
                    return weather[2];
                } else {
                    return weather[0];
                }

            }
        } else if (height <= 30) {
            if (longitude <= 20) {

                if (latitude <= 30) {
                    return weather[1];
                } else {
                    return weather[2];
                }

            } else if (longitude <= 60) {

                if (latitude <= 30) {
                    return weather[0];
                } else {
                    return weather[2];
                }

            } else {

                if (latitude <= 30) {
                    return weather[3];
                } else {
                    return weather[2];
                }

            }
        } else if (height <= 40) {
            if (longitude <= 20) {

                if (latitude <= 30) {
                    return weather[0];
                } else {
                    return weather[1];
                }

            } else if (longitude <= 60) {

                if (latitude <= 30) {
                    return weather[3];
                } else {
                    return weather[0];
                }

            } else {

                if (latitude <= 30) {
                    return weather[1];
                } else {
                    return weather[3];
                }

            }
        } else if (height <= 50) {
            if (longitude <= 20) {

                if (latitude <= 30) {
                    return weather[0];
                } else {
                    return weather[3];
                }

            } else if (longitude <= 60) {

                if (latitude <= 30) {
                    return weather[0];
                } else {
                    return weather[3];
                }

            } else {

                if (latitude <= 30) {
                    return weather[0];
                } else {
                    return weather[3];
                }

            }
        } else {
            return weather [3];
        }
    }
}