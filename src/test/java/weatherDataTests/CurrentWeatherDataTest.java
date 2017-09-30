package weatherDataTests;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;

public class CurrentWeatherDataTest {
    private WeatherRequest weatherDataRequest;
    private CurrentWeatherData currentWeatherData;
    private double longitudeTallinn;
    private double latitudeTallinn;


    @Before
    public void initObjects(){
        latitudeTallinn = 0;
        longitudeTallinn = 0;
        weatherDataRequest = new WeatherDataRequest();

    }

    @Test
    public void testIfResponseHasCoordinates() {
        assertNotEquals(null, currentWeatherData.getLatitude());
        assertNotEquals(null, currentWeatherData.getLongitude());
    }

    @Test
    public void testIfResponseCityMatchesRequestedCity() {
        assertEquals(weatherDataRequest.getCity(),currentWeatherData.getCity());
    }

    @Test
    public void testIfResponseCoordinatesMatchesTallinnCoordinates() {
        assertEquals(weatherDataRequest.getLatitude(),latitudeTallinn);
        assertEquals(weatherDataRequest.getLongitude(),longitudeTallinn);

    }

    @Test
    public void testIfResponseHasTemperature() {
        assertNotEquals(null, currentWeatherData.getTemp());
    }










}
