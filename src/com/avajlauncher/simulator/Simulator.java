package com.avajlauncher.simulator;

import com.avajlauncher.simulator.aircraft.AircraftFactory;
import com.avajlauncher.simulator.aircraft.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {

    public static void main(String[] args) {

        try {
            String simBlueprint = args[0];
            FileReader fileReader = new FileReader(simBlueprint);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            if (line != null) {

                int simulations = Integer.parseInt(line.split(" ") [0]);
                if (simulations < 0) {
                    System.out.println("Please provide a positive number of simulation runs!");
                    System.exit(0);
                }

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    Flyable object = AircraftFactory.newAircraft(line.split("")[0], line.split("")[1],
                            Integer.parseInt(line.split("")[0]), Integer.parseInt(line.split("")[0]),
                            Integer.parseInt(line.split("")[0]));
                    flyables.add(object);
                }

                while (simulations != 0) {
                    simulations--;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file: " + args[0]);
        } catch (IOException e) {
            System.out.println("Unable to read from file argument: " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide a file argument!");
        }
    }
}
