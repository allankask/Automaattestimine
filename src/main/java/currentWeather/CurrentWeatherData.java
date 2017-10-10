package currentWeather;

public class CurrentWeatherData {
    private String city;
    private String countryCode;
    private double temp;
    private double latitude;
    private double longitude;

    public CurrentWeatherData(String city, String countryCode, double temp, double latitude, double longitude) {
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
}