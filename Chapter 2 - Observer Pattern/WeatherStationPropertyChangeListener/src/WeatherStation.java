public class WeatherStation {
    public static void main(String[] args) {
        WeatherData observable =  new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(); 
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        observable.addPropertyChangeListener(currentDisplay);
        observable.addPropertyChangeListener(statisticsDisplay);
        observable.addPropertyChangeListener(heatIndexDisplay);
        observable.addPropertyChangeListener(forecastDisplay);
        
        observable.setMeasurements(80, 65, 30.4f);
        observable.setMeasurements(82, 70, 29.2f);
        observable.setMeasurements(78, 90, 29.2f);
    }
}
