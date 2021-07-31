package de.exxcellent.challenge;


import de.exxcellent.challenge.reader.CSVReader;
import de.exxcellent.challenge.reader.Reader;
import de.exxcellent.challenge.reader.data.strategies.MinDistanceStrategy;

public final class App {

    public static void main(String... args) {
        //Task 1
        CSVReader csvReaderWeather = new CSVReader("de/exxcellent/challenge/weather.csv", ",", true);
        InformationCollector informationCollector = new InformationCollector(csvReaderWeather);
        informationCollector.setDataStrategy(new MinDistanceStrategy("MxT", "MnT", "Day"));
        informationCollector.executeStrategy();

        //Task 2
        Reader csvReaderFootball = new CSVReader("de/exxcellent/challenge/football.csv", ",", true);
        informationCollector = new InformationCollector(csvReaderFootball);
        informationCollector.setDataStrategy(new MinDistanceStrategy("Goals", "Goals Allowed", "Team"));
        informationCollector.executeStrategy();
    }
}
