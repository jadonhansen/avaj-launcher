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
        this.id = nextId();
    }

    private long nextId() {
        return idCounter++;
    }

    protected void missionReport(String type, String conditions) {

        switch (conditions) {
            case "RAIN":
                System.out.println(type + "#" + this.name + "(" + this.id +  "):" + " rain...");
                break;
            case "FOG":
                System.out.println(type + "#" + this.name + "(" + this.id +  "):" + " fog...");
                break;
            case "SUN":
                System.out.println(type + "#" + this.name + "(" + this.id +  "):" + " sun...");
                break;
            case "SNOW":
                System.out.println(type + "#" + this.name + "(" + this.id +  "):" + " snow...");
                break;
            default:
                System.out.println("Unidentified weather condition: '" + conditions + "'.");
        }
    }

    protected void reportLanding(String type) {
        System.out.println(type + "#" + this.name + "(" + this.id +  "):" + " Landing...");
    }
}