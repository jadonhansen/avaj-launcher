package com.avajlauncher.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {

    public static void main(String[] args) {

            if (args[0] != null) {

                try {
                    String simBlueprint = args[0];
                    FileReader fr = new FileReader(simBlueprint);
                    BufferedReader bf = new BufferedReader(fr);
                    String line = bf.readLine();

                    while (line != null) {
                        System.out.println(line);
//                    do validation
                        line = bf.readLine();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Unable to find file: " + args[0]);
                } catch (IOException e) {
                    System.out.println("Unable to read from file argument: " + args[0]);
                }


            } else {
                System.out.println("Please provide a file as an argument!");
                System.exit(0);
            }
    }
}
