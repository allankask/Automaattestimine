package weatherDataTests;

import model.CurrentWeatherData;
import repository.CurrentWeatherRepository;
import org.junit.Before;
import org.junit.Test;
import model.WeatherRequest;


import java.io.IOException;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

public class CurrentWeatherDataTest {
    private WeatherRequest weatherRequest;
    private CurrentWeatherData currentWeatherData;
    private CurrentWeatherRepository currentWeatherRepository;
    private String URL = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn&APPID=fd427f21785ae9daac151dc00fc9e46f&units=metric";



    @Before
    public void initObjects() throws IOException {
        weatherRequest = new WeatherRequest("Tallinn", "EE", "metric");
        currentWeatherRepository = new CurrentWeatherRepository();
        currentWeatherData = currentWeatherRepository.JSONResponseIntoCurrentWeatherData(weatherRequest);
    }
    @Test
    public void testIfURIBuilderBuildsAProperURLForCurrentWeatherRequest() {
        String result = CurrentWeatherRepository.buildCurrentWeatherURL(weatherRequest);
        assertEquals(result, URL);

    }

    @Test
    public void testIfResponseHasCoordinates() {
        assertNotEquals(null, currentWeatherData.getLatitude());
        assertNotEquals(null, currentWeatherData.getLongitude());
    }

    @Test
    public void testIfResponseCityMatchesRequestedCity() {
        assertEquals(weatherRequest.getCity(),currentWeatherData.getCity());
    }


    @Test
    public void testIfResponseHasTemperature() {
        assertNotEquals(null, currentWeatherData.getTemp());
    }


    @Test
    public void testIfCoordinatesAreValid() {
        boolean latitudeIsValid = currentWeatherData.getLatitude() <= 90 && currentWeatherData.getLatitude() >= -90;
        boolean longitudeIsValid = currentWeatherData.getLongitude() <= 180 && currentWeatherData.getLongitude() >= -180;
        assertEquals(true, latitudeIsValid);
        assertEquals(true, longitudeIsValid);
    }

    @Test
    public void testIfTemperatureIsValid() {
        boolean temperatureIsValid = currentWeatherData.getTemp() > -100 && currentWeatherData.getTemp()< 100;
        assertEquals(true, temperatureIsValid);
    }







}
