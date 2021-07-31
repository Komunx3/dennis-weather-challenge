package de.exxcellent.challenge;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.Reader;
import de.exxcellent.challenge.reader.data.strategies.DataStrategy;

public class InformationCollector {

    private final Reader reader;
    private DataStrategy dataStrategy;

    InformationCollector(Reader reader){
        this.reader = reader;
    }

    public void setDataStrategy(DataStrategy dataStrategy) {
        this.dataStrategy = dataStrategy;
    }

    public void executeStrategy() {
        if (dataStrategy == null) {
            System.out.println("No strategy set");
            return;
        }

        try {
            String strategyResult = dataStrategy.execute(reader);
            System.out.println(strategyResult);
        } catch (IllegalFormatException | DataNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

}
