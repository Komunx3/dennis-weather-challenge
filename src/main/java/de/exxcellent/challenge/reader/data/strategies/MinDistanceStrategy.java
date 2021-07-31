package de.exxcellent.challenge.reader.data.strategies;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.Reader;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;

public class MinDistanceStrategy implements DataStrategy {

    private String columnToDisplay;
    private String columnToFilter1;
    private String columnToFilter2;

    public MinDistanceStrategy(String columnToFilter1, String columnToFilter2, String columnToDisplay) {
        this.columnToFilter1 = columnToFilter1;
        this.columnToFilter2 = columnToFilter2;
        this.columnToDisplay = columnToDisplay;
    }

    @Override
    public void execute(Reader reader) {
        List<HashMap<String, String>> data = null;
        try {
            data = reader.getData();
        } catch (IllegalFormatException | DataNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        int smallestDistance = -1;
        HashMap<String, String> smallestDistanceEntry = null;

        for (HashMap<String, String> rowData : data) {

            int value1 = Integer.parseInt(rowData.get(columnToFilter1));
            int value2 = Integer.parseInt(rowData.get(columnToFilter2));
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

        if (smallestDistanceEntry == null) {
            System.out.println(String.format("No result for minimal distance between %s and %s",
                    columnToFilter1, columnToFilter2));
        }
        else if(smallestDistanceEntry.get(columnToDisplay) == null){
            System.out.println("Result for minimal distance found but value to display is null");
        }
        else {
            System.out.println(String.format("Result for minimal distance between %s and %s: %s",
                    columnToFilter1, columnToFilter2, smallestDistanceEntry.get(columnToDisplay)));
        }
    }
}
