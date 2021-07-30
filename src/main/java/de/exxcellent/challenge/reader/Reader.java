package de.exxcellent.challenge.reader;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;

public abstract class Reader {

    protected String dataPath;

    protected Reader(String dataPath) {
        this.dataPath = dataPath;
    }

    abstract List<HashMap<String, String>> getData() throws IllegalFormatException, DataNotAvailableException;
}
