public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Weather is going to be better!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More or less the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch and don't forget your umbrella, rainy weather");
		}
	}
}