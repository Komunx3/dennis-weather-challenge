package de.exxcellent.challenge.reader.data.strategies;

import java.util.HashMap;
import java.util.List;

public class MinDistanceStrategy implements DataStrategy {

    private String keyColumn1;
    private String keyColumn2;

    public MinDistanceStrategy(String keyColumn1, String keyColumn2) {
        this.keyColumn1 = keyColumn1;
        this.keyColumn2 = keyColumn2;
    }

    @Override
    public HashMap<String, String> execute(List<HashMap<String, String>> data) {

        int smallestDistance = -1;
        HashMap<String, String> smallestDistanceEntry = null;

        for (HashMap<String, String> rowData : data) {

            int value1 = Integer.parseInt(rowData.get(keyColumn1));
            int value2 = Integer.parseInt(rowData.get(keyColumn2));
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
}
