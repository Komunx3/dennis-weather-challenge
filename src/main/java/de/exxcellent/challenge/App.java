package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.CSVReader;

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
        System.out.println(moduleManager.executeModule_Weather());
    }
}
