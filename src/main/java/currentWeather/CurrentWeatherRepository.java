package currentWeather;



import httpUtilities.HttpUtilities;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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


public class CurrentWeatherRepository {

    private static final String API_KEY = "fd427f21785ae9daac151dc00fc9e46f";




    public static String buildCurrentWeatherURL(WeatherRequest request){
        UriBuilder builder = UriBuilder
                .fromPath("http://api.openweathermap.org")
                .path("/data/2.5/weather")
                .queryParam("q", request.getCity())
                .queryParam("APPID", API_KEY)
                .queryParam("units", request.getFormat());

        URL url = null;

        try{
            url = builder.build().toURL();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url.toString();
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
        JSONObject sys = (JSONObject) weatherDataInJson.get("sys");
        JSONObject main = (JSONObject) weatherDataInJson.get("main");
        JSONObject coord = (JSONObject) weatherDataInJson.get("coord");
        String city = (String) weatherDataInJson.get("name");
        String country = (String) sys.get("country");
        long temp = (long) main.get("temp");
        double longitude = (double) coord.get("lon");
        double latitude = (double) coord.get("lat");
        CurrentWeatherData currentWeatherData = new CurrentWeatherData(city, country, temp, latitude, longitude);
        return currentWeatherData;
    }



}









