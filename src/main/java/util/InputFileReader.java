package util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import model.WeatherRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.List;


public class InputFileReader {


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
    public static WeatherRequest getWeatherRequestByNameFromFile(String filePath, String searchedName) {
        JSONArray jArr = InputFileReader.readFileAsJSONArray(filePath);
        String cityName;

        if (jArr != null) {
            for (Object obj : jArr) {
                JSONObject jObj = (JSONObject) obj;
                cityName = (String) jObj.get("cityName");

                if (cityName.equals(searchedName)) {
                    return new WeatherRequest(cityName,(String)
                            jObj.get("countryCode"),(String) jObj.get("formatOfUnits"));
                }
            }

        }

        return null;
    }

    public static List<WeatherRequest> getWeatherRequestListFromFile(String filePath) {
        JSONArray jArr = InputFileReader.readFileAsJSONArray(filePath);
        List<WeatherRequest> requestList = new ArrayList<>();

        for (Object obj : jArr) {
            JSONObject jObj = (JSONObject) obj;
            requestList.add(new WeatherRequest((String) jObj.get("cityName"),
                    (String) jObj.get("countryCode"),(String) jObj.get("formatOfUnits")));
        }

        return requestList;
    }

    /**
     * Read file as JSON array
     * @return
     */
    public static JSONArray readFileAsJSONArray(String filePath) {

        JSONParser jParser = new JSONParser();

        try {
            Object obj = jParser.parse(new java.io.FileReader(filePath));
            return (JSONArray) obj;

        } catch (IOException ex) {
            System.out.println("File error: " + ex);
        } catch (ParseException ex) {
            System.out.println("Parse error: " + ex);
        }

        return null;
    }
}
