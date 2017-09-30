package httpUtilitiesTest;

import org.junit.Test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;


public class HttpUtilityTest {

    private WeatherRequest weatherDataRequest;
    private CurrentWeatherData currentWeatherData;
    private ForecastWeatherData forecastWeatherData;

    private String currentWeatherURL;
    private String forecastWeatherURL;


    @Before
    public void initObjects() {
        weatherDataRequest = new WeatherDataRequest();

    }

    @Test
    public void testIfCurrentWeatherDataStatusIsOK(){

    }

    @Test
    public void testIfForecastWeatherDataStatusIsOK(){

    }




}