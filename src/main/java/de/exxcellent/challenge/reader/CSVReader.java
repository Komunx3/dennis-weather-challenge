package de.exxcellent.challenge.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class CSVReader {


    private String relativeFilePath;

    /**
     * @param relativeFilePath an relative path to the file (package path included)
     */
    public CSVReader(String relativeFilePath) {
        this.relativeFilePath = relativeFilePath;
    }

    public List<HashMap<String, String>> getData() throws FileNotFoundException {
        InputStream inputStream = getFileFromResourceAsStream(relativeFilePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines().forEach(n -> System.out.println(n));

        //TODO getData() is not fully implemented yet
        return null;
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
