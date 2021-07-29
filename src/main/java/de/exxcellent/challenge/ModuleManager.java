package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.CSVReader;

public class ModuleManager {


    public String executeModule_Weather() {
        CSVReader csvReader = new CSVReader("de/exxcellent/challenge/weather.csv");
        try {
            List<HashMap<String, String>> data = csvReader.getData();

            int smallestDistance = -1;
            HashMap<String, String> smallestDistanceEntry = null;

            for (HashMap<String, String> rowData : data) {
                int distance = Integer.parseInt(rowData.get("MxT")) - Integer.parseInt(rowData.get("MnT"));

                if (smallestDistance == -1) {
                    smallestDistance = distance;
                    smallestDistanceEntry = rowData;
                    continue;
                }

                if (distance < smallestDistance) {
                    smallestDistance = distance;
                    smallestDistanceEntry = rowData;
                }
            }

            return String.format("Day with smallest temperature spread: %s",
                    smallestDistanceEntry.get("Day"));
        } catch (FileNotFoundException | IllegalFormatException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
