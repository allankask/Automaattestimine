package model;

import org.json.simple.JSONObject;

public class WeatherRequest {
    private String city;
    private String countryCode;
    private String formatOfUnits;

    public WeatherRequest(String city, String countryCode, String formatOfUnits) {
        this.city = city;
        this.countryCode = countryCode;
        this.formatOfUnits = formatOfUnits;
    }

    public String getCity() {
        return city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getFormat() {
        return formatOfUnits;
    }

    public JSONObject asJson() {
        JSONObject jObj = new JSONObject();
        jObj.put("cityName", city);
        jObj.put("countryCode", countryCode);
        jObj.put("formatOfUnits", formatOfUnits);

        return jObj;
    }
}
