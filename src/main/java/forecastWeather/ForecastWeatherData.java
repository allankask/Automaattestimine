package forecastWeather;

public class ForecastWeatherData {
    private String city;
    private String country;
    private double longitude;
    private double latitude;
    private ForecastOneDayData firstDayWeather;
    private ForecastOneDayData secondDayWeather;
    private ForecastOneDayData thirdDayWeather;

    public ForecastWeatherData(String city, String country, double longitude, double latitude, ForecastOneDayData firstDayWeather, ForecastOneDayData secondDayWeather, ForecastOneDayData thirdDayWeather) {
        this.city = city;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
        this.firstDayWeather = firstDayWeather;
        this.secondDayWeather = secondDayWeather;
        this.thirdDayWeather = thirdDayWeather;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public ForecastOneDayData getfirstDayWeather() {
        return firstDayWeather;
    }

    public ForecastOneDayData getsecondDayWeather() {
        return secondDayWeather;
    }

    public ForecastOneDayData getthirdDayWeather() {
        return thirdDayWeather;
    }
}
