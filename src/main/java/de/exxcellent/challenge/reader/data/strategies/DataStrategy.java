package de.exxcellent.challenge.reader.data.strategies;

import java.util.HashMap;
import java.util.List;


public interface DataStrategy {
    HashMap<String, String> execute(List<HashMap<String, String>> data);
}
