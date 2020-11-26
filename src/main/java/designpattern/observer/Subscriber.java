package designpattern.observer;

/**
 * Created by bsankar on 6/11/2014.
 */
public interface Subscriber {
    public void update(float temp, float humidity, float pressure);
}
