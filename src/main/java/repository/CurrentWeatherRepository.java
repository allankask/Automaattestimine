package repository;



import util.HttpUtilities;
import model.CurrentWeatherData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import model.WeatherRequest;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class CurrentWeatherRepository {

    private static final String API_KEY = "fd427f21785ae9daac151dc00fc9e46f";


    public static String buildCurrentWeatherURL(WeatherRequest request){
        UriBuilder builder = UriBuilder
                .fromPath("http://api.openweathermap.org")
                .path("/data/2.5/weather")
                .queryParam("q", request.getCity())
                .queryParam("APPID", API_KEY)
                .queryParam("units", request.getFormat());



        try{
            URL url = builder.build().toURL();
            return url.toString();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getCurrentWeatherData(WeatherRequest weatherRequest) throws IOException {
        HttpURLConnection request = HttpUtilities.makeHttpGetRequest(buildCurrentWeatherURL(weatherRequest));
        request.connect();
        JSONParser parseJson = new JSONParser();
        JSONObject jsonObject = null;
        try{
            jsonObject = (JSONObject) parseJson.parse(new InputStreamReader((InputStream) request.getContent()));
        }  catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        request.disconnect();
        return jsonObject;
    }

    public CurrentWeatherData JSONResponseIntoCurrentWeatherData(WeatherRequest weatherRequest) throws IOException {
        JSONObject weatherDataInJson = getCurrentWeatherData(weatherRequest);
        JSONObject sysInfo = (JSONObject) weatherDataInJson.get("sys");
        JSONObject mainInfo = (JSONObject) weatherDataInJson.get("main");
        JSONObject coordinates = (JSONObject) weatherDataInJson.get("coord");
        String city = (String) weatherDataInJson.get("name");
        String country = (String) sysInfo.get("country");
        long temp = (long) mainInfo.get("temp");
        double longitude = (double) coordinates.get("lon");
        double latitude = (double) coordinates.get("lat");
        CurrentWeatherData currentWeatherData = new CurrentWeatherData(city, country, temp, latitude, longitude);
        return currentWeatherData;
    }






}









