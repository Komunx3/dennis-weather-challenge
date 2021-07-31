package de.exxcellent.challenge.reader.data.strategies;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.Reader;
import java.util.HashMap;
import java.util.List;

public class MinDistanceStrategy implements DataStrategy {

    private final String columnToDisplay;
    private final String columnToFilter1;
    private final String columnToFilter2;

    public MinDistanceStrategy(String columnToFilter1, String columnToFilter2, String columnToDisplay) {
        this.columnToFilter1 = columnToFilter1;
        this.columnToFilter2 = columnToFilter2;
        this.columnToDisplay = columnToDisplay;
    }

    @Override
    public String execute(Reader reader) throws IllegalFormatException, DataNotAvailableException {
        List<HashMap<String, String>> data = reader.getData();

        /* Check if data is available to calculate this strategy */
        if (data.size() == 0)
            return String.format("No result for minimal distance between %s and %s",
                    columnToFilter1, columnToFilter2);

        /* Check if column names exist in data */
        long missingColumnData = data.stream().filter(n -> !n.containsKey(columnToDisplay)
                        || !n.containsKey(columnToFilter1)
                        || !n.containsKey(columnToFilter2)).count();

        if (missingColumnData > 0)
            return "Missing column data in reader data";


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

        return String.format("Result for minimal distance between %s and %s: %s",
                columnToFilter1, columnToFilter2, smallestDistanceEntry.get(columnToDisplay));
    }
}
