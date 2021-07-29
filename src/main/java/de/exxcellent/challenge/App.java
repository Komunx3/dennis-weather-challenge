package de.exxcellent.challenge;


import java.io.FileNotFoundException;

import de.exxcellent.challenge.exceptions.IllegalFormatException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        ModuleManager moduleManager = new ModuleManager();

        try {
            System.out.println(moduleManager.executeModule_Weather());
            System.out.println(moduleManager.executeModule_Football());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalFormatException e) {
            e.printStackTrace();
        }
    }
}
