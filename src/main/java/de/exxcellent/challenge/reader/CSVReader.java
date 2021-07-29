package de.exxcellent.challenge.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import de.exxcellent.challenge.exceptions.IllegalFormatException;


public class CSVReader {

    private String relativeFilePath;

    /**
     * @param relativeFilePath an relative path to the file (package path included)
     */
    public CSVReader(String relativeFilePath) {
        this.relativeFilePath = relativeFilePath;
    }

    public List<HashMap<String, String>> getData() throws FileNotFoundException, IllegalFormatException {
        InputStream inputStream = getFileFromResourceAsStream(relativeFilePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        List<String> lines = bufferedReader.lines().collect(Collectors.toList());

        /* Collecting headers and data of csv file */
        List<String> columnHeadings = Arrays.asList(lines.get(0).split(","));
        List<String> rowLines = lines.subList(1, lines.size());

        /* Checking for incorrect format */
        if (rowLines.stream().anyMatch(row -> row.split(",").length != columnHeadings.size()))
            throw new IllegalFormatException("Illegal format of csv file");

        List<HashMap<String, String>> mappedRows = new ArrayList<>();
        for (String rowLine : rowLines) {
            HashMap<String, String> mappedRow = new HashMap<>();
            String[] valuesOfSingleRow = rowLine.split(",");

            for (int i = 0; i < valuesOfSingleRow.length; i++) {
                mappedRow.put(columnHeadings.get(i), valuesOfSingleRow[i]);
            }
            mappedRows.add(mappedRow);
        }
        return mappedRows;
    }

    private InputStream getFileFromResourceAsStream(String fileName) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new FileNotFoundException("File not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}
