package httpUtilitiesTest;

import repository.CurrentWeatherRepository;
import repository.ForecastWeatherRepository;
import util.HttpUtilities;

import org.junit.Test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import model.WeatherRequest;


public class HttpUtilityTest {

    private WeatherRequest weatherRequest;
    private CurrentWeatherRepository currentWeatherRepository;
    private ForecastWeatherRepository forecastWeatherRepository;
    private HttpUtilities httpUtilities;



    @Before
    public void initObjects() {
       currentWeatherRepository = new CurrentWeatherRepository();
       forecastWeatherRepository = new ForecastWeatherRepository();
       weatherRequest = new WeatherRequest("Tallinn", "EE", "metric");
        httpUtilities = new HttpUtilities();

    }

    @Test
    public void testIfCurrentWeatherDataStatusIsOK(){
        assertEquals(200, httpUtilities.getHTTPStatus(currentWeatherRepository.buildCurrentWeatherURL(weatherRequest)));
    }

    @Test
    public void testIfForecastWeatherDataStatusIsOK(){
        assertEquals(200, httpUtilities.getHTTPStatus(forecastWeatherRepository.buildForecastWeatherURL(weatherRequest)));
    }



}