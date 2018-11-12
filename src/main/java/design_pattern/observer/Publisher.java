package design_pattern.observer;

/**
 * Created by bsankar on 6/11/2014.
 */
public interface Publisher {
    public void registerSubscriber(Subscriber subscriber);

    public void removeSubscriber(Subscriber subscriber);

    public void notifySubscriber();
}
