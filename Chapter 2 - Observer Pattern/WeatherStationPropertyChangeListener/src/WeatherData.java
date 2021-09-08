import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WeatherData {

    private PropertyChangeSupport support;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.support = new PropertyChangeSupport(this);
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure) {

        support.firePropertyChange("temperature", this.temperature, temperature);
        support.firePropertyChange("humidity", this.humidity, humidity);
        support.firePropertyChange("pressure", this.pressure, pressure);
 
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setTemperature(float temperature) {
        support.firePropertyChange("temperature", this.temperature, temperature);
        this.temperature = temperature;
    }
    
    public void setHumidity(float humidity) {
        support.firePropertyChange("humidity", this.humidity, humidity);
        this.humidity = humidity;
    }

    public void setPressure(float pressure) {
        support.firePropertyChange("pressure", this.pressure, pressure);
        this.pressure = pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}