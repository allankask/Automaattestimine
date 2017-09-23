import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

public class WeatherDataTest {
    @Test
    public void testTallinnCoordinates() {
        String cityCoordinates = "";
        assertEquals(cityCoordinates, weather.getCityCoordinates());
    }

    @Test
    public void testTempDataFrom3DaysForecast() {

        assertTrue(weather.hasTempMin());
        assertTrue(weather.hasTempMax());
        assertTrue(weather.hasCurrentTemp());
    }

    @Test
    public void testWeatherData() {
        assertTrue(weather.hasCoordinates());
        assertTrue(weather.hasHumidity());
        assertTrue(weather.hasPressure());
        assertTrue(weather.hasWindDirection());
        assertTrue(weather.hasWindSpeed());
        assertTrue(weather.hasClouds());
        assertTrue(weather.hasCurrentTemp());
    }

    @Test
    public void testActualAndExpectedData(){
        fail();
    }








}
