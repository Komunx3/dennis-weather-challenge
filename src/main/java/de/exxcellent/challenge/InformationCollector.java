package de.exxcellent.challenge;

import java.util.HashMap;
import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.Reader;
import de.exxcellent.challenge.reader.data.strategies.DataStrategy;

public class InformationCollector {

    private Reader reader;
    private DataStrategy dataStrategy;

    InformationCollector(Reader reader){
        this.reader = reader;
    }

    public void setDataStrategy(DataStrategy dataStrategy) {
        this.dataStrategy = dataStrategy;
    }

    public HashMap<String, String> getDataEntryForStrategy() throws IllegalFormatException,
            DataNotAvailableException {
        if (dataStrategy == null)
            return null;

        return dataStrategy.execute(reader.getData());
    }
}
