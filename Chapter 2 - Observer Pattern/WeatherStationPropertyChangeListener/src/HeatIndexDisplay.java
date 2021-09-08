import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class HeatIndexDisplay implements PropertyChangeListener, DisplayElement {
	
	float heatIndex = 0.0f;
	float temperature = 0.0f;
	float humidity = 0.0f;

	public HeatIndexDisplay() {}

	// public void update(Observable obs, Object arg) {
	// 	if (obs instanceof WeatherData) {
    //         WeatherData weatherData = (WeatherData) obs;
	// 		heatIndex = computeHeatIndex(weatherData.getTemperature(), weatherData.getHumidity());
	// 		display();
	// 	}
	// }
	
	private float computeHeatIndex(float t, float rh) {
		float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) 
			+ (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) 
			+ (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
			(0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 * 
			(rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) + 
			(0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
			0.000000000843296 * (t * t * rh * rh * rh)) -
			(0.0000000000481975 * (t * t * t * rh * rh * rh)));
		return index;
	}

	public void display() {
		System.out.println("Heat index is " + heatIndex);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		if ("temperature".equals(propertyName)) {
			this.setTemperature((float) evt.getNewValue());
		} else if ("humidity".equals(propertyName)) {
			this.setHumidity((float) evt.getNewValue());
		}

		heatIndex = computeHeatIndex(this.temperature, this.humidity);
		this.setHeatIndex(heatIndex);
		this.display();
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public void setHeatIndex(float heatIndex) {
		this.heatIndex = heatIndex;
	}
}