package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsankar on 6/11/2014.
 */
public class WeatherData implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<Subscriber>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void registerSubscriber(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    public void removeSubscriber(Subscriber subscriber) {
        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        }
    }

    public void notifySubscriber() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifySubscriber();
    }
}
