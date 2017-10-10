package weatherDataTests;

import currentWeather.CurrentWeatherData;
import currentWeather.CurrentWeatherRepository;
import org.junit.Before;
import org.junit.Test;
import weatherRequest.WeatherRequest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;

public class CurrentWeatherDataTest {
    private WeatherRequest weatherRequest;
    private CurrentWeatherData currentWeather;
    private double longitudeTallinn;
    private double latitudeTallinn;
    private String URL = "http:api.openweathermap.org/data/2.5/weather?q=Tallinn&APPID=fd427f21785ae9daac151dc00fc9e46f&units=metric";


    @Before
    public void initObjects(){
        latitudeTallinn = 0;
        longitudeTallinn = 0;
        weatherRequest = new WeatherRequest("Tallinn", "EE", "metric");

    }
    @Test
    public void testIfURIBuilderBuildsAProperURL() {
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
    public void testIfResponseCoordinatesMatchesTallinnCoordinates() {
        assertEquals(weatherRequest.getLatitude(),latitudeTallinn);
        assertEquals(weatherRequest.getLongitude(),longitudeTallinn);

    }

    @Test
    public void testIfResponseHasTemperature() {
        assertNotEquals(null, currentWeatherData.getTemp());
    }










}
