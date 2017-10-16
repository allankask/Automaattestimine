package weatherDataTests;

import currentWeather.CurrentWeatherData;
import currentWeather.CurrentWeatherRepository;
import org.junit.Before;
import org.junit.Test;
import weatherRequest.WeatherRequest;


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









}
