package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;

import java.util.HashMap;
import java.util.List;

public abstract class Reader {

    protected final String dataPath;
    protected final boolean internalSource;
    protected long lastUpdate;
    protected List<HashMap<String, String>> data;

    protected Reader(String dataPath, boolean internalSource) {
        this.dataPath = dataPath;
        this.internalSource = internalSource;
    }

    public List<HashMap<String, String>> getData() throws IllegalFormatException, DataNotAvailableException {
        if (data == null){
            updateData();
            lastUpdate = System.currentTimeMillis();
        }
        else {
            /* Internal resources can´t be updated at runtime. -> For example: football.csv and weather.csv */
            if(!internalSource && dataUpdateNeeded()) {
                updateData();
                lastUpdate = System.currentTimeMillis();
            }
        }
        return data;
    }

    protected abstract boolean dataUpdateNeeded();

    protected abstract void updateData() throws IllegalFormatException, DataNotAvailableException;

}
