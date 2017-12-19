package weatherDataTests;


import model.ForecastWeatherData;
import repository.ForecastWeatherRepository;
import org.junit.Before;
import org.junit.Test;
import model.WeatherRequest;


import java.io.IOException;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

public class ForecastWeatherDataTest {

    private WeatherRequest weatherRequest;
    private ForecastWeatherData forecastWeatherData;
    private ForecastWeatherRepository forecastWeatherRepository;

    private String URL = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn&APPID=fd427f21785ae9daac151dc00fc9e46f&units=metric";

    private double latitudeTallinn = 59.43;
    private double longitudeTallinn = 24.75;



    @Before
    public void initObjects() throws IOException {

        weatherRequest = new WeatherRequest("Tallinn", "EE", "metric");
        forecastWeatherRepository = new ForecastWeatherRepository();
        forecastWeatherData = forecastWeatherRepository.JSONResponseIntoForecastData(weatherRequest) ;



    }


    @Test
    public void testIfURIBuilderBuildsAProperURLForForecastWeatherRequest() {
        String result = ForecastWeatherRepository.buildForecastWeatherURL(weatherRequest);
        assertEquals(result, URL);
    }

    @Test
    public void testIfResponseHasCoordinates() {
        assertNotEquals(null, forecastWeatherData.getLatitude());
        assertNotEquals(null, forecastWeatherData.getLongitude());
    }

    @Test
    public void testIfResponseCityMatchesRequestedCity() {
        assertEquals(weatherRequest.getCity(),forecastWeatherData.getCity());
    }

    @Test
    public void testIfResponseCoordinatesMatchesTallinnCoordinates() {
        assertEquals(forecastWeatherData.getLatitude(),latitudeTallinn, 2);
        assertEquals(forecastWeatherData.getLongitude(),longitudeTallinn, 2);
    }

    @Test
    public void testIfResponseDayOneHasMinAndMaxTemperatures() {
        assertNotEquals(null, forecastWeatherData.getfirstDayWeather().getMaxTemp());
        assertNotEquals(null, forecastWeatherData.getfirstDayWeather().getMinTemp());

    }
    @Test
    public void testIfResponseDayTwoHasMinAndMaxTemperatures() {
        assertNotEquals(null, forecastWeatherData.getsecondDayWeather().getMaxTemp());
        assertNotEquals(null, forecastWeatherData.getsecondDayWeather().getMinTemp());

    }
    @Test
    public void testIfResponseDayThreeHasMinAndMaxTemperatures() {
        assertNotEquals(null, forecastWeatherData.getthirdDayWeather().getMaxTemp());
        assertNotEquals(null, forecastWeatherData.getthirdDayWeather().getMinTemp());

    }

    @Test
    public void testIfResponseHasThreeDayForecast() {
        assertNotEquals(null, forecastWeatherData.getfirstDayWeather());
        assertNotEquals(null, forecastWeatherData.getsecondDayWeather());
        assertNotEquals(null, forecastWeatherData.getthirdDayWeather());

    }


}

