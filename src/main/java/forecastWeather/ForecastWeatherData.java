package forecastWeather;

public class ForecastWeatherData {
    private String city;
    private String countryCode;
    private double longitude;
    private double latitude;
    private ForecastOneDayData firstDayWeather;
    private ForecastOneDayData secondDayWeather;
    private ForecastOneDayData thirdDayWeather;

    public ForecastWeatherData(String city, String countryCode, double longitude, double latitude, ForecastOneDayData firstDayWeather, ForecastOneDayData secondDayWeather, ForecastOneDayData thirdDayWeather) {
        this.city = city;
        this.countryCode = countryCode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.firstDayWeather = firstDayWeather;
        this.secondDayWeather = secondDayWeather;
        this.thirdDayWeather = thirdDayWeather;
    }

    public String getCity() {
        return city;
    }

    public String getcountryCode() {
        return countryCode;
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
