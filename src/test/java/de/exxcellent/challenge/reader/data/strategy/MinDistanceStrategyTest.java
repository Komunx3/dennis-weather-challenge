package de.exxcellent.challenge.reader.data.strategy;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import de.exxcellent.challenge.reader.CSVReader;
import de.exxcellent.challenge.reader.data.strategies.MinDistanceStrategy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MinDistanceStrategyTest {

    private final String fileName_CorrectData = "weather_correct.csv";
    private final String fileName_IncorrectData = "weather_incorrect.csv";
    private final String fileName_OnlyHeaderData = "only_header.csv";

    @Test
    void execute_Test() throws IllegalFormatException, DataNotAvailableException {
        CSVReader csvReader = new CSVReader(fileName_CorrectData,",", true);
        MinDistanceStrategy strategy = new MinDistanceStrategy("MxR", "Mn", "Day");
        String result = strategy.execute(csvReader);

        assertEquals("Result for minimal distance between MxR and Mn: 4", result, "Wrong got picked");
    }

    @Test
    void executeMissingData_Test() throws IllegalFormatException, DataNotAvailableException {
        CSVReader csvReader = new CSVReader(fileName_OnlyHeaderData,",", true);
        MinDistanceStrategy strategy = new MinDistanceStrategy("a", "b", "Day");
        String result = strategy.execute(csvReader);

        assertEquals("No result for minimal distance between a and b", result, "Wrong got picked");
    }

    @Test
    void executeMissingColumnData_Test() throws IllegalFormatException, DataNotAvailableException {
        CSVReader csvReader = new CSVReader(fileName_CorrectData,",", true);
        MinDistanceStrategy strategy = new MinDistanceStrategy("MxR", "Nonsense", "Day");
        String result = strategy.execute(csvReader);

        assertEquals("Missing column data in reader data", result, "Column data is missing");
    }

    @Test
    void executeIncorrectData_Test() throws IllegalFormatException, DataNotAvailableException {
        CSVReader csvReader = new CSVReader(fileName_IncorrectData,",", true);
        MinDistanceStrategy strategy = new MinDistanceStrategy("MxR", "Mn", "Day");

        assertThrows(IllegalFormatException.class, () -> strategy.execute(csvReader),
                "No IllegalFormatException got thrown for invalid data format");
    }

    @Test
    void executeNoData_Test() {
        CSVReader csvReader = new CSVReader(fileName_IncorrectData + "nonSense.x",",", true);
        MinDistanceStrategy strategy = new MinDistanceStrategy("MxR", "Mn", "Day");

        assertThrows(DataNotAvailableException.class, () -> strategy.execute(csvReader),
                "No DataNotAvailableException got thrown for non existing data");
    }

}
