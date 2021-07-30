package de.exxcellent.challenge.reader;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVReaderTest {

    private String fileName_CorrectData = "weather_correct.csv";
    private String fileName_IncorrectData = "weather_incorrect.csv";

    @Test
    void getData_Test() throws DataNotAvailableException, IllegalFormatException {
        CSVReader csvReader = new CSVReader(fileName_CorrectData,",");
        List<HashMap<String,String>> data = csvReader.getData();
        assertEquals(7, data.size());
    }

    @Test
    void getData_Exception_FileNotFound_Test()  {
        CSVReader csvReader = new CSVReader(fileName_CorrectData + "incorrect Path", ",");
        assertThrows(DataNotAvailableException.class, () -> csvReader.getData());
    }

    @Test
    void getData_Exception_IllegalFormat_Test()  {
        CSVReader csvReader = new CSVReader(fileName_IncorrectData, ",");
        assertThrows(IllegalFormatException.class, () -> csvReader.getData());
    }

}
