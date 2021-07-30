package de.exxcellent.challenge.reader;

import java.util.HashMap;
import java.util.List;
import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;

public interface Reader {

    List<HashMap<String, String>> getData() throws IllegalFormatException, DataNotAvailableException;
}
