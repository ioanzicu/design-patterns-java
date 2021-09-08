import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ForecastDisplay implements PropertyChangeListener, DisplayElement {
	
	private float currentPressure = 29.92f;  
	private float lastPressure;
	

	public ForecastDisplay() {}

	
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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		if ("pressure".equals(propertyName)) {
			this.setPressure((float) evt.getNewValue());

			display();
		}
	}

	public void setPressure(float pressure) {
		this.lastPressure = currentPressure;
		this.currentPressure = pressure;
	}
}