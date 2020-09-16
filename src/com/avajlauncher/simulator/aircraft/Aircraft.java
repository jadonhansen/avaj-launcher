package com.avajlauncher.simulator.aircraft;

import com.avajlauncher.weather.Coordinates;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    // will create a new file only if it doesn't already exist
    protected void saveReport(String entry) {
        try {
            File record = new File("simulation.txt");
            if (record.createNewFile()) {
                FileWriter fw = new FileWriter("simulation.txt");
                fw.write(entry);
                fw.close();
            } else {
                FileWriter fw = new FileWriter("simulation.txt", true);
                fw.write(entry);
                fw.close();
            }
        } catch (IOException e) {
            System.out.print("Error while creating simulation.txt: " + e);
        }
        try {
            File record = new File("simulation.txt");
            if (record.createNewFile()) {
                FileWriter fw = new FileWriter("simulation.txt");
                fw.write(entry);
                fw.close();
            } else {
                FileWriter fw = new FileWriter("simulation.txt", true);
                fw.write(entry);
                fw.close();
            }
        } catch (IOException e) {
            System.out.print("Error while creating simulation.txt: " + e);
        }
    }

    protected void missionReport(String type, String conditions) {

        String report = type + "#" + this.name + "(" + this.id +  "): ";

        switch (conditions) {
            case "RAIN":
                switch (type) {
                    case "Balloon":
                        this.saveReport(report + "Damn son things are getting gnarly around here\n");
                        break;
                    case "Helicopter":
                        this.saveReport(report + "It's just a breeze, don't worry about it!\n");
                        break;
                    case "JetPlane":
                        this.saveReport(report + "Why rain? Why?\n");
                        break;
                    default:
                        System.out.println("Unidentified flying object encountered: " + type);
                }
                break;
            case "FOG":
                switch (type) {
                    case "Balloon":
                        this.saveReport(report + "I can't see the ground guys...\n");
                        break;
                    case "Helicopter":
                        this.saveReport(report + "Okay, who let off the smoke bomb?\n");
                        break;
                    case "JetPlane":
                        this.saveReport(report + "If this gets any thicker we're officially screwed!\n");
                        break;
                    default:
                        System.out.println("Unidentified flying object encountered: " + type);
                }
                break;
            case "SUN":
                switch (type) {
                    case "Balloon":
                        this.saveReport(report + "Off to Everest we goooo...\n");
                        break;
                    case "Helicopter":
                        this.saveReport(report + "See that bird there?\n");
                        break;
                    case "JetPlane":
                        this.saveReport(report + "Now this is what I call a tanning day on the beach!\n");
                        break;
                    default:
                        System.out.println("Unidentified flying object encountered: " + type);
                }
                break;
            case "SNOW":
                switch (type) {
                    case "Balloon":
                        this.saveReport(report + "Aight imma head out :)\n");
                        break;
                    case "Helicopter":
                        this.saveReport(report + "Mission impossible got nothing on us\n");
                        break;
                    case "JetPlane":
                        this.saveReport(report + "Thank goodness for jet engines!\n");
                        break;
                    default:
                        System.out.println("Unidentified flying object encountered: " + type);
                }
                break;
            default:
                System.out.println("Unidentified weather condition: '" + conditions + "'.");
        }
    }

    protected void reportLanding(String type) {
        String report = type + "#" + this.name + "(" + this.id +  "):" + " Landing...\n";
        this.saveReport(report);
    }
}