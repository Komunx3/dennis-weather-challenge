package de.exxcellent.challenge.reader;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import de.exxcellent.challenge.exceptions.DataNotAvailableException;
import de.exxcellent.challenge.exceptions.IllegalFormatException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVReaderTest {

    private final String fileName_CorrectData = "weather_correct.csv";
    private final String fileName_IncorrectData = "weather_incorrect.csv";
    private final String fileName_EmptyFile = "empty_file.csv";
    private final String fileName_OnlyHeader = "only_header.csv";

    @Test
    void getData_Test() throws DataNotAvailableException, IllegalFormatException {
        CSVReader csvReader = new CSVReader(fileName_CorrectData,",", true);
        List<HashMap<String,String>> data = csvReader.getData();
        assertEquals(7, data.size());
    }

    @Test
    void getData_EmptyFile_Test(){
        CSVReader csvReader = new CSVReader(fileName_EmptyFile,",", true);
        assertThrows(DataNotAvailableException.class, csvReader::getData);
    }

    @Test
    void getData_OnlyHeader_Test() throws IllegalFormatException, DataNotAvailableException {
        CSVReader csvReader = new CSVReader(fileName_OnlyHeader,",", true);
        int size = csvReader.getData().size();
        assertEquals(0, size, "Data exists even though no data entrys exist");
    }

    @Test
    void getData_Exception_FileNotFound_Test()  {
        CSVReader csvReader = new CSVReader(fileName_CorrectData + "incorrect Path", ",", true);
        assertThrows(DataNotAvailableException.class, csvReader::getData);
    }

    @Test
    void getData_Exception_IllegalFormat_Test()  {
        CSVReader csvReader = new CSVReader(fileName_IncorrectData, ",",true);
        assertThrows(IllegalFormatException.class, csvReader::getData);
    }
}
