package currentWeather;



import weatherRequest.WeatherRequest;

import javax.ws.rs.core.UriBuilder;
import java.net.MalformedURLException;
import java.net.URL;


public class CurrentWeatherRepository {

    private static final String API_KEY = "fd427f21785ae9daac151dc00fc9e46f";


    public static String buildCurrentWeatherURL(WeatherRequest weatherRequest){
        UriBuilder builder = UriBuilder
                .fromPath("api.openweathermap.org")
                .scheme("http")
                .path("/data/2.5/weather")
                .queryParam("q", weatherRequest.getCity())
                .queryParam("APPID", API_KEY)
                .queryParam("units", weatherRequest.getFormat());

        URL url = null;

        try{
            url = builder.build().toURL();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url.toString();

    }





}









