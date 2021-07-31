package de.exxcellent.challenge.reader.data.strategies;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.Reader;


public interface DataStrategy {
    String execute(Reader reader) throws IllegalFormatException, DataNotAvailableException;
}
