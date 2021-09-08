import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CurrentConditionsDisplay implements PropertyChangeListener, DisplayElement {
    
    private float temperature;
    private float humidity;
    

    public CurrentConditionsDisplay() {}

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if ("temperature".equals(propertyName)) {
            this.setTemperature((float) evt.getNewValue());
            
            this.display();
        } else if ("humidity".equals(propertyName)) {
            this.setHumidity((float) evt.getNewValue());
            
            this.display();
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}