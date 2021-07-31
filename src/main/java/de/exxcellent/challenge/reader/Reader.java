package de.exxcellent.challenge.reader;

import java.util.HashMap;
import java.util.List;
import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;

public abstract class Reader {

    protected String dataPath;
    protected boolean internalSource;
    protected List<HashMap<String, String>> data;
    protected long lastUpdate;

    protected Reader(String dataPath, boolean internalSource) {
        this.dataPath = dataPath;
        this.internalSource = internalSource;
    }

    public List<HashMap<String, String>> getData() throws IllegalFormatException, DataNotAvailableException {
        if (dataUpdateNeeded())
            updateData();

        return data;
    }

    protected abstract boolean dataUpdateNeeded();

    protected abstract void updateData() throws IllegalFormatException, DataNotAvailableException;

}
