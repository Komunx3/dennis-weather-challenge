package de.exxcellent.challenge;


import java.util.HashMap;
import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.CSVReader;
import de.exxcellent.challenge.reader.JsonReader;
import de.exxcellent.challenge.reader.Reader;
import de.exxcellent.challenge.reader.data.strategies.MinDistanceStrategy;

public final class App {

    public static void main(String... args) {


        CSVReader csvReaderWeather = new CSVReader("de/exxcellent/challenge/weather.csv", ",", true);
        csvReaderWeather.dataUpdateNeeded();

        InformationCollector informationCollector = new InformationCollector(csvReaderWeather);
        informationCollector.setDataStrategy(new MinDistanceStrategy("MxT", "MnT"));

        try {
            HashMap<String, String> dataEntry = informationCollector.getDataEntryForStrategy();
            System.out.println(dataEntry.toString());
        } catch (IllegalFormatException | DataNotAvailableException e) {
            e.printStackTrace();
        }


        Reader csvReaderFootball = new CSVReader("de/exxcellent/challenge/football.csv", ",", true);
        informationCollector = new InformationCollector(csvReaderFootball);
        informationCollector.setDataStrategy(new MinDistanceStrategy("Goals", "Goals Allowed"));

        try {
            HashMap<String, String> dataEntry = informationCollector.getDataEntryForStrategy();
            System.out.println(dataEntry.toString());
        } catch (IllegalFormatException | DataNotAvailableException e) {
            e.printStackTrace();
        }
    }
}
