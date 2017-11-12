package fileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import weatherRequest.WeatherRequest;

import java.io.IOException;

public class FileReader {


    public WeatherRequest readDataFromFile (String inputFileName)   {
        JSONParser jsonParser = new JSONParser();
        WeatherRequest weatherRequest = null;
        try {
            java.io.FileReader fileReader = new java.io.FileReader("C:\\Users\\Allan\\Desktop\\input.txt");

            JSONObject inputFile = (JSONObject) jsonParser.parse(fileReader);

            String cityName = (String) inputFile.get("cityName");
            String countryCode = (String) inputFile.get("countryCode");
            String formatOfUnits = (String) inputFile.get("formatOfUnits");

            weatherRequest = new WeatherRequest(cityName, countryCode, formatOfUnits);

        } catch (IOException | ParseException exception)   {
            exception.printStackTrace();
        }
        return weatherRequest;
    }
}
