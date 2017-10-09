package weatherDataTests;


import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;

public class ForecastWeatherDataTest {
    //private WeatherRequest weatherDataRequest;
    //private ForecastWeatherData forecastWeatherData;
    private double longitudeTallinn;
    private double latitudeTallinn;


    @Before
    public void initObjects(){
        latitudeTallinn = 0;
        longitudeTallinn = 0;
        //weatherDataRequest = new WeatherDataRequest();

    }

    @Test
    public void testIfResponseHasCoordinates() {
        assertNotEquals(null, forecastWeatherData.getLatitude());
        assertNotEquals(null, forecastWeatherData.getLongitude());
    }

    @Test
    public void testIfResponseCityMatchesRequestedCity() {
        assertEquals(weatherDataRequest.getCity(),forecastWeatherData.getCity());
    }

    @Test
    public void testIfResponseCoordinatesMatchesTallinnCoordinates() {
        assertEquals(weatherDataRequest.getLatitude(),latitudeTallinn);
        assertEquals(weatherDataRequest.getLongitude(),longitudeTallinn);

    }

    @Test
    public void testIfResponseHasMinAndMaxTemperatures() {
        assertNotEquals(null, forecastWeatherData.getMaxTemp());
        assertNotEquals(null, forecastWeatherData.getMinTemp());

    }

    @Test
    public void testIfResponseHasThreeDayForecast() {
        assertNotEquals(null, forecastWeatherData.getFirstDay());
        assertNotEquals(null, forecastWeatherData.getSecondDay());
        assertNotEquals(null, forecastWeatherData.getThirdDay());

    }


}

