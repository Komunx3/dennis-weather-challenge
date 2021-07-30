package de.exxcellent.challenge;


import java.io.FileNotFoundException;

import de.exxcellent.challenge.exceptions.IllegalFormatException;


public final class App {

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
