package de.exxcellent.challenge;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.CSVReader;

public class ModuleManager {


    private HashMap<String, String> getSmallestDifference(CSVReader csvReader, String column1, String column2)
            throws IllegalFormatException, DataNotAvailableException {

        List<HashMap<String, String>> data = csvReader.getData();

        int smallestDistance = -1;
        HashMap<String, String> smallestDistanceEntry = null;

        for (HashMap<String, String> rowData : data) {

            int value1 = Integer.parseInt(rowData.get(column1));
            int value2 = Integer.parseInt(rowData.get(column2));
            int distance = Math.abs(value1 - value2);

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

        return smallestDistanceEntry;
    }

    public String executeModule_Football() throws IllegalFormatException, DataNotAvailableException {
        CSVReader csvReader = new CSVReader("de/exxcellent/challenge/football.csv", ",");

        HashMap<String, String> entry = getSmallestDifference(
                csvReader,
                "Goals",
                "Goals Allowed");

        return "Team with smallest distance: " + entry.get("Team");
    }

    public String executeModule_Weather() throws IllegalFormatException, DataNotAvailableException {
        CSVReader csvReader = new CSVReader("de/exxcellent/challenge/weather.csv", ",");

        HashMap<String, String> entry = getSmallestDifference(
                csvReader,
                "MxT",
                "MnT");
        return "Day of smallest temperature spread: " + entry.get("Day");
    }
}
