package design_pattern.observer;

/**
 * Created by bsankar on 6/11/2014.
 */
public class CurrentConditionsDisplay implements Subscriber, DisplayElement {
    private float temperature;
    private float humidity;
    //private Publisher weatherData;

    public CurrentConditionsDisplay(Publisher weatherData) {
        weatherData.registerSubscriber(this);
    }

    public String display() {
        return "Current conditions: " + temperature + "F degrees and " + humidity + "%humidity";
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
