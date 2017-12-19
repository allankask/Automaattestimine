package model;

import org.json.simple.JSONObject;

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

    public JSONObject asJson() {
        JSONObject jObj = new JSONObject();
        jObj.put("minTemp", (float) minTemp);
        jObj.put("maxTemp", (float) maxTemp);

        return jObj;
    }


}
