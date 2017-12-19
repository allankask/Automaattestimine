package repository;

import util.HttpUtilities;
import model.ForecastOneDayData;
import model.ForecastWeatherData;
import org.json.simple.JSONArray;
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
import java.sql.Timestamp;


public class ForecastWeatherRepository {

    private static final String API_KEY ="fd427f21785ae9daac151dc00fc9e46f";



    public static String buildForecastWeatherURL(WeatherRequest weatherRequest){
        UriBuilder builder = UriBuilder
                .fromPath("http://api.openweathermap.org")
                .path("/data/2.5/forecast")
                .queryParam("q", weatherRequest.getCity())
                .queryParam("APPID", API_KEY)
                .queryParam("units", weatherRequest.getFormat());


        try{
            URL url = builder.build().toURL();
            return url.toString();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;

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
        String countryCode = (String) cityObject.get("country");
        ForecastOneDayData dayOne = getOneDayData(forecastDataInJason, 1);
        ForecastOneDayData dayTwo = getOneDayData(forecastDataInJason, 2);
        ForecastOneDayData dayThree = getOneDayData(forecastDataInJason, 3);
        ForecastWeatherData forecastReport = new ForecastWeatherData(cityName, countryCode, longitude, latitude, dayOne, dayTwo, dayThree);
        return forecastReport;
    }

    public ForecastOneDayData getOneDayData(JSONObject forecastDataObject, int day){
        int currentDayOfMonth = (new Timestamp(System.currentTimeMillis())).toLocalDateTime().getDayOfMonth();
        JSONArray forecast = (JSONArray) forecastDataObject.get("list");

        double latestMinTemp = Integer.MAX_VALUE;
        double latestMaxTemp = Integer.MIN_VALUE;
        for (int i = 0; i < forecast.size(); i++)   {
            JSONObject singleForecastObject = (JSONObject) forecast.get(i);
            Timestamp timestamp = new Timestamp((Long) singleForecastObject.get("dt") * 1000);
            JSONObject mainObject = (JSONObject) singleForecastObject.get("main");
            Object minTemperatureObject = mainObject.get("temp_min");
            Object maxTemperatureObject = mainObject.get("temp_max");
            double minTempValue = new Double(minTemperatureObject.toString());
            double maxTempValue = new Double(maxTemperatureObject.toString());
            int daysFromToday = timestamp.toLocalDateTime().getDayOfMonth() - currentDayOfMonth;
            if (daysFromToday == day)   {
                if (minTempValue < latestMinTemp) {
                    latestMinTemp = minTempValue;
                }
                if (maxTempValue < latestMaxTemp) {
                    latestMaxTemp = maxTempValue;
                }
            }
        }
        ForecastOneDayData oneDayReport = new ForecastOneDayData(latestMaxTemp,latestMinTemp);
        return oneDayReport;
    }

}
