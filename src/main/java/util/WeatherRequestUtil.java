package util;

import model.CurrentWeatherData;
import model.ForecastWeatherData;
import model.WeatherRequest;
import org.json.simple.JSONObject;
import repository.CurrentWeatherRepository;
import repository.ForecastWeatherRepository;

import java.io.IOException;
import java.util.List;

public class WeatherRequestUtil {

    public static boolean getWeatherDataByInputFileDataAndWriteIntoFile(String inputFilePath, String outputFolderPath) {

        List<WeatherRequest> requestList = InputFileReader.getWeatherRequestListFromFile(inputFilePath);

        CurrentWeatherRepository currentWeatherRepository = new CurrentWeatherRepository();
        ForecastWeatherRepository forecastWeatherRepository = new ForecastWeatherRepository();

        //Java 8 Lambda method
        requestList.forEach((weatherRequest) -> {
            try {

                CurrentWeatherData currentWeatherData = currentWeatherRepository.JSONResponseIntoCurrentWeatherData(weatherRequest);
                ForecastWeatherData forecastWeatherData  = forecastWeatherRepository.JSONResponseIntoForecastData(weatherRequest);

                JSONObject coords = new JSONObject();
                coords.put("longitude", currentWeatherData.getLongitude());
                coords.put("latitude", currentWeatherData.getLatitude());

                JSONObject jObj = new JSONObject();
                jObj.put("cityName", weatherRequest.getCity());
                jObj.put("coordinates", coords);
                jObj.put("firstDay",forecastWeatherData.getfirstDayWeather().asJson());
                jObj.put("secondDay", forecastWeatherData.getsecondDayWeather().asJson());
                jObj.put("thirdDay", forecastWeatherData.getthirdDayWeather().asJson());
                jObj.put("currentTemp", currentWeatherData.getTemp());

                String outputFilePath = outputFolderPath + "\\" + weatherRequest.getCity() + ".txt";
                FileWriter.writeDataToFile(outputFilePath, jObj);

            } catch (IOException ex) {
                System.out.println("File error: " + ex);
                System.out.println("Something went wrong");
            }
        });

        return true;
    }

    public static boolean getWeatherDataByCityNameAndWriteToFile(String inputFilePath, String outputFilePath, String cityName) {

        WeatherRequest weatherRequest = InputFileReader.getWeatherRequestByNameFromFile(inputFilePath, cityName);

        if (weatherRequest == null) {
            System.out.println("No such city in input file!");
            return false;
        }

        CurrentWeatherRepository currentWeatherRepository = new CurrentWeatherRepository();
        ForecastWeatherRepository forecastWeatherRepository = new ForecastWeatherRepository();

        try {
            CurrentWeatherData weatherData = currentWeatherRepository.JSONResponseIntoCurrentWeatherData(weatherRequest);
            FileWriter.writeDataToFile(outputFilePath, weatherData.asJson());

        } catch (IOException ex) {
            System.out.println("File error: " + ex);
        }

        return true;
    }
}
