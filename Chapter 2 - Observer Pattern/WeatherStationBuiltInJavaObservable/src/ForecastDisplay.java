import java.util.Observable; 
import java.util.Observer; 


public class ForecastDisplay implements Observer, DisplayElement {
	
	Observable observable;
	private float currentPressure = 29.92f;  
	private float lastPressure;
	

	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.lastPressure = currentPressure;
			this.currentPressure = weatherData.getPressure();

			display();
		}
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