package model;

import org.json.simple.JSONObject;

public class CurrentWeatherData {
    private String city;
    private String countryCode;
    private long temp;
    private double latitude;
    private double longitude;

    public CurrentWeatherData(String city, String countryCode, long temp, double latitude, double longitude) {
        this.city = city;
        this.countryCode = countryCode;
        this.temp = temp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getTemp() {
        return temp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public JSONObject asJson() {
        JSONObject jObj = new JSONObject();
        jObj.put("cityName", city);
        jObj.put("countryCode", countryCode);
        jObj.put("temp", temp);
        jObj.put("latitude", latitude);
        jObj.put("longitude", longitude);

        return jObj;
    }
}

