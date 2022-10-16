public class WeatherInfo {

    private String timestamp;
    private double temperature;

    WeatherInfo(String timestamp, double temperature){
        this.timestamp = timestamp;
        this.temperature = temperature;

    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getTemperature() {
        return temperature;
    }
}
