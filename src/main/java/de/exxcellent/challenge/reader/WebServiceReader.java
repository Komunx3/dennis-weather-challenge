package de.exxcellent.challenge.reader;

import java.util.HashMap;
import java.util.List;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class WebServiceReader extends Reader {

    public WebServiceReader(String urlToWebService) {
        super(urlToWebService, false);
    }

    @Override
    protected boolean dataUpdateNeeded() {
        throw new NotImplementedException();
    }

    @Override
    protected void updateData() {
        throw new NotImplementedException();
    }

}
