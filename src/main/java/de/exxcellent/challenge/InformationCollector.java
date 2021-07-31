package de.exxcellent.challenge;

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

    public void executeStrategy() {
        if (dataStrategy == null) {
            System.out.println("No strategy set");
            return;
        }
        dataStrategy.execute(reader);
    }


}
