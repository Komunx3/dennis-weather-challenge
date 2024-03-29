package de.exxcellent.challenge.reader;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class JsonReader extends Reader {

    public JsonReader(String dataPath, boolean internalSource) {
        super(dataPath, internalSource);
    }

    @Override
    protected boolean dataUpdateNeeded() {
        throw new NotImplementedException();
    }

    @Override
    protected void updateData(){
        /*
        No Task in this challenge, but possible to build with the external library "JFlat".
        This library can convert a json data structure to a flat data structure like csv.
        Example: JFlat flatMe = new JFlat(jsonString);
         */
        throw new NotImplementedException();
    }

}
