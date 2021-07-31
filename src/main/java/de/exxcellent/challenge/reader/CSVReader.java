package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class CSVReader extends Reader{

    private final String valueSeparator;

    /**
     * @param filePath Absolute path if it is an external source. Relative path if it´s an internal source.
     */
    public CSVReader(String filePath, String valueSeparator, boolean internalSource) {
        super(filePath, internalSource);
        this.valueSeparator = valueSeparator;
    }

    @Override
    protected void updateData() throws IllegalFormatException, DataNotAvailableException {
        InputStream inputStream = null;
        try {
            inputStream = getFileFromResourceAsStream(dataPath);
        } catch (FileNotFoundException e) {
            throw new DataNotAvailableException("CSV File could not be found: " + getFileName());
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());

        /* Check if column headings and data entries exists*/
        if (lines.size() == 0) {
            throw new DataNotAvailableException("No Data available");
        }
        else if(lines.size() == 1) {
            data = new ArrayList<>();
            return;
        }

        /* Collecting headers and data of csv file */
        List<String> columnHeadings = Arrays.asList(lines.get(0).split(valueSeparator));
        List<String> rowLines = lines.subList(1, lines.size());

        /* Checking for incorrect format */
        if (rowLines.stream().anyMatch(row -> row.split(valueSeparator).length != columnHeadings.size()))
            throw new IllegalFormatException("Illegal format of csv file: " + getFileName());

        List<HashMap<String, String>> dataResult = new ArrayList<>();
        for (String rowLine : rowLines) {
            HashMap<String, String> mappedRow = new HashMap<>();
            String[] valuesOfSingleRow = rowLine.split(valueSeparator);

            for (int i = 0; i < valuesOfSingleRow.length; i++) {
                mappedRow.put(columnHeadings.get(i), valuesOfSingleRow[i]);
            }
            dataResult.add(mappedRow);
        }
        data = dataResult;
    }

    @Override
    protected boolean dataUpdateNeeded() {
        File externalFile = new File(dataPath);
        return externalFile.lastModified() > lastUpdate;
    }

    private String getFileName(){
        return new File(dataPath).getName();
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
