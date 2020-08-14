package com.avajlauncher.simulator.aircraft;

import com.avajlauncher.weather.Coordinates;

public abstract class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;

        this.id = idCounter++;
//        id must be set but is this correct???
    }

    private long nextId() {
        return idCounter + 1; //CORRECT????
    }
}