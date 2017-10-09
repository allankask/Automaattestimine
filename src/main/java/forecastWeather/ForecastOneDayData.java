package forecastWeather;

public class ForecastOneDayData {
    private double maxTemp;
    private double minTemp;

    public ForecastOneDayData(double maxTemp, double minTemp) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }


}
