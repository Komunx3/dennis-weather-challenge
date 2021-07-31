package de.exxcellent.challenge.reader;

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
