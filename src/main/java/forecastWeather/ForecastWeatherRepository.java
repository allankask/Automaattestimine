package forecastWeather;

import httpUtilities.HttpUtilities;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import weatherRequest.WeatherRequest;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ForecastWeatherRepository {

    private static final String API_KEY ="fd427f21785ae9daac151dc00fc9e46f";



    public static String buildForecastWeatherURL(WeatherRequest weatherRequest){
        UriBuilder builder = UriBuilder
                .fromPath("http://api.openweathermap.org")
                .path("/data/2.5/forecast")
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
    public JSONObject getForecastWeatherData(WeatherRequest weatherRequest) throws IOException {
        HttpURLConnection request = HttpUtilities.makeHttpGetRequest(buildForecastWeatherURL(weatherRequest));
        request.connect();
        JSONParser parseJson = new JSONParser();
        JSONObject jsonObject = null;
        try{
            jsonObject = (JSONObject) parseJson.parse(new InputStreamReader((InputStream) request.getContent(),"UTF-8"));
        }  catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        request.disconnect();
        return jsonObject;
    }

    public ForecastWeatherData JSONResponseIntoForecastData (WeatherRequest weatherRequest) throws IOException {
        JSONObject forecastDataInJason = getForecastWeatherData(weatherRequest);
        JSONObject cityObject = (JSONObject) forecastDataInJason.get("city");
        JSONObject coord = (JSONObject) cityObject.get("coord");
        double latitude = (double) coord.get("lat");
        double longitude = (double) coord.get("lon");
        String cityName = (String) cityObject.get("name");
        String country = (String) cityObject.get("country");
        ForecastOneDayData dayOne = getOneDayData(forecastDataInJason, 1);
        ForecastOneDayData dayTwo = getOneDayData(forecastDataInJason, 2);
        ForecastOneDayData dayThree = getOneDayData(forecastDataInJason, 3);
        ForecastWeatherData forecastReport = new ForecastWeatherData(cityName, country, longitude, latitude, dayOne, dayTwo, dayThree);
        return forecastReport;
    }

    public ForecastOneDayData getOneDayData(JSONObject forecast, int day){

    }

}
