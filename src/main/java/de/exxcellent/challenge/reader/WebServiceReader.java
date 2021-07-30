package de.exxcellent.challenge.reader;

import java.util.HashMap;
import java.util.List;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;

public class WebServiceReader extends Reader {

    public WebServiceReader(String urlToWebService) {
        super(urlToWebService);
    }

    @Override
    public List<HashMap<String, String>> getData() throws IllegalFormatException, DataNotAvailableException {
       /* No Task in this challenge, but possible to build */
       return null;
    }

}
